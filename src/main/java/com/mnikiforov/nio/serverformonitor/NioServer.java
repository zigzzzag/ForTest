package com.mnikiforov.nio.serverformonitor;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class NioServer implements Runnable {

    private InetAddress hostAddress;
    private ServerSocketChannel serverChannel;
    private Selector selector;
    private ByteBuffer readBuffer = ByteBuffer.allocate(8192);
    private EchoWorker worker;
    private List changeRequests = new LinkedList();
    private Map pendingData = new HashMap();
    private int port;

    private Selector initSelector() throws IOException {
        Selector socketSelector = SelectorProvider.provider().openSelector();

        this.serverChannel = ServerSocketChannel.open();
        serverChannel.configureBlocking(false);

        InetSocketAddress isa = new InetSocketAddress(this.hostAddress, this.port);
        serverChannel.socket().bind(isa);

        serverChannel.register(socketSelector, SelectionKey.OP_ACCEPT);

        return socketSelector;
    }

    public void run() {
        while (true) {
            try {
                synchronized (this.changeRequests) {
                    Iterator changes = this.changeRequests.iterator();
                    while (changes.hasNext()) {
                        ChangeRequest change = (ChangeRequest) changes.next();
                        switch (change.type) {
                            case ChangeRequest.CHANGEOPS:
                                SelectionKey key = change.socket.keyFor(this.selector);
                                if (key == null) {
                                    socks.remove(change.socket);
                                } else {
                                    key.interestOps(change.ops);
                                }
                        }
                    }
                    this.changeRequests.clear();
                }

                this.selector.select();

                Iterator selectedKeys = this.selector.selectedKeys().iterator();
                while (selectedKeys.hasNext()) {
                    SelectionKey key = (SelectionKey) selectedKeys.next();
                    selectedKeys.remove();

                    if (!key.isValid()) {
                        continue;
                    }

                    if (key.isAcceptable()) {
                        this.accept(key);
                        System.out.println("accept");
                    } else if (key.isReadable()) {
                        this.read(key);
                        System.out.println("read");
                    } else if (key.isWritable()) {
                        this.write(key);
                        System.out.println("write");
                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(NioServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void read(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();

        this.readBuffer.clear();

        int numRead;
        try {
            numRead = socketChannel.read(this.readBuffer);
        } catch (IOException e) {
            System.out.println("IOException: channel().close()");
            key.cancel();
            socketChannel.close();
            return;
        }

        if (numRead == -1) {
            System.out.println("channel().close()");
            key.channel().close();
            key.cancel();
            return;
        }

        System.out.println("numRead " + numRead);
        this.worker.processData(this, socketChannel, this.readBuffer.array(), numRead);
    }
    private List<SocketChannel> socks = new ArrayList<SocketChannel>();

    private void accept(SelectionKey key) throws IOException {
        ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();

        SocketChannel socketChannel = serverSocketChannel.accept();
        Socket socket = socketChannel.socket();
        socketChannel.configureBlocking(false);

        socketChannel.register(this.selector, SelectionKey.OP_READ);
        socks.add(socketChannel);
    }

    public void send(SocketChannel socket, byte[] data) {
        synchronized (this.changeRequests) {
            for (SocketChannel socketChannel : socks) {
                this.changeRequests.add(new ChangeRequest(socketChannel, ChangeRequest.CHANGEOPS, SelectionKey.OP_WRITE));
                synchronized (this.pendingData) {
                    List queue = (List) this.pendingData.get(socketChannel);
                    if (queue == null) {
                        queue = new ArrayList();
                        this.pendingData.put(socket, queue);
                    }
                    queue.add(ByteBuffer.wrap(data));
                }
            }
        }

        this.selector.wakeup();
    }

    private void write(SelectionKey key) throws IOException {
        SocketChannel socketChannel = (SocketChannel) key.channel();
        synchronized (this.pendingData) {
            List queue = (List) this.pendingData.get(socketChannel);

            if (queue == null) {
                return;
            }
            while (!queue.isEmpty()) {
                ByteBuffer buf = (ByteBuffer) queue.get(0);
                socketChannel.write(buf);
                if (buf.remaining() > 0) {
                    break;
                }
                queue.remove(0);
            }

            if (queue.isEmpty()) {
                key.interestOps(SelectionKey.OP_READ);
            }
        }
    }

    public NioServer(InetAddress hostAddress, int port, EchoWorker worker) throws IOException {
        this.hostAddress = hostAddress;
        this.port = port;
        this.selector = this.initSelector();
        this.worker = worker;
    }

    public static void main(String[] args) {
        try {
            EchoWorker worker = new EchoWorker();
            new Thread(worker).start();
            new Thread(new NioServer(null, 9999, worker)).start();
        } catch (IOException ex) {
            Logger.getLogger(NioServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
