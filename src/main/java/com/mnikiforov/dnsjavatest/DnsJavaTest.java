/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mnikiforov.dnsjavatest;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.xbill.DNS.Address;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.MXRecord;
import org.xbill.DNS.Message;
import org.xbill.DNS.Name;
import org.xbill.DNS.Record;
import org.xbill.DNS.Resolver;
import org.xbill.DNS.SimpleResolver;
import org.xbill.DNS.TSIG;
import org.xbill.DNS.TextParseException;
import org.xbill.DNS.Type;
import org.xbill.DNS.Update;
import org.xbill.DNS.utils.base64;

/**
 * @author mnikiforov
 */
public class DnsJavaTest {

    public static void main(String[] args) {
        try {
            InetAddress addr = Address.getByName("www.dnsjava.org");
            System.out.println(addr.toString());
        } catch (UnknownHostException ex) {
            Logger.getLogger(DnsJavaTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Get the MX target and preference of a name:
        try {
            Record[] records = new Lookup("gmail.com", Type.MX).run();
            for (int i = 0; i < records.length; i++) {
                MXRecord mx = (MXRecord) records[i];
                System.out.println("Host " + mx.getTarget() + " has preference " + mx.getPriority());
            }
        } catch (TextParseException ex) {
            Logger.getLogger(DnsJavaTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Query a remote name server for its version:
//	try {
//	    Lookup l = new Lookup("version.bind.", Type.TXT, DClass.CH);
//	    l.setResolver(new SimpleResolver(args[0]));
//	    l.run();
//	    if (l.getSucces() == Lookup.SUCCESSFUL) {
//		System.out.println(l.getAnswers()[0].rdataToString());
//	    }
//	} catch (TextParseException ex) {
//	    Logger.getLogger(DnsJavaTest.class.getName()).log(Level.SEVERE, null, ex);
//	} catch (UnknownHostException ex) {
//	    Logger.getLogger(DnsJavaTest.class.getName()).log(Level.SEVERE, null, ex);
//	}
        //Transfer a zone from a server and print it:
//	try {
//	    ZoneTransferIn xfr = ZoneTransferIn.newAXFR(new Name("."), "192.5.5.241", null);
//	    List records = xfr.run();
//	    for (Iterator it = records.iterator(); it.hasNext();) {
//		System.out.println(it.next());
//	    }
//	} catch (UnknownHostException ex) {
//	    Logger.getLogger(DnsJavaTest.class.getName()).log(Level.SEVERE, null, ex);
//	} catch (TextParseException ex) {
//	    Logger.getLogger(DnsJavaTest.class.getName()).log(Level.SEVERE, null, ex);
//	} catch (IOException ex) {
//	    Logger.getLogger(DnsJavaTest.class.getName()).log(Level.SEVERE, null, ex);
//	} catch (ZoneTransferException ex) {
//	    Logger.getLogger(DnsJavaTest.class.getName()).log(Level.SEVERE, null, ex);
//	}
//	Use DNS dynamic update to set the address of a host to a value specified on the command line:
        try {
            Name zone = Name.fromString("dyn.test.example.");

            Name host = Name.fromString("host", zone);
            Update update = new Update(zone);
            update.replace(host, Type.A, 3600, "127.0.0.1");

            System.out.println(update);

            Resolver res = new SimpleResolver("127.0.0.1");
            res.setTSIGKey(new TSIG(host, base64.fromString("8888")));
            res.setTCP(true);

            Message response = res.send(update);
        } catch (TextParseException ex) {
            Logger.getLogger(DnsJavaTest.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DnsJavaTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
