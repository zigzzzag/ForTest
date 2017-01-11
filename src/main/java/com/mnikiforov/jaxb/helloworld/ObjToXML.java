package com.mnikiforov.jaxb.helloworld;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

/**
 * Created by zigzzzag on 11.03.16.
 */
public class ObjToXML {

    public static void main(String[] args) {
        Customer customer = new Customer();
        customer.setId(100);
        customer.setName("Ivan");
        customer.setAge(66);

        try {
            File file = new File("test.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Customer.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            // output pretty printed
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(customer, file);
            jaxbMarshaller.marshal(customer, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
