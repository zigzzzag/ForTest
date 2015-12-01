package com.mnikiforov.hibernate.java_brains.g_crud;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by sbt-nikiforov-mo on 27.11.15.
 */
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int id;

    private String serialNumber;

    public Product() {
    }

    public Product(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
