package com.mnikiforov.rmi.server.engine;

import com.mnikiforov.rmi.server.compute.Compute;
import com.mnikiforov.rmi.server.compute.Task;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by Zigzag on 27.10.2015.
 */
public class ComputeEngine implements Compute {

    static String hostname = "127.0.1.1";

    public ComputeEngine() {
        super();
    }

    @Override
    public <T> T executeTask(Task<T> t) {
        return t.execute();
    }

    public static void main(String[] args) {
//        if (System.getSecurityManager() == null) {
//            System.setSecurityManager(new SecurityManager());
//        }
        try {
            String name = "Compute";
            Compute engine = new ComputeEngine();

            Compute stub = (Compute) UnicastRemoteObject.exportObject(engine, 0);

            Registry registry = LocateRegistry.getRegistry(hostname, Registry.REGISTRY_PORT);
            registry.lookup(hostname);

            registry.rebind(name, stub);
            System.out.println("ComputeEngine bound");
        } catch (Exception e) {
            System.err.println("ComputeEngine exception:");
            e.printStackTrace();
        }
    }
}
