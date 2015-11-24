package com.mnikiforov.hibernate.dto;

import javax.persistence.Embeddable;

/**
 * Created by sbt-nikiforov-mo on 24.11.15.
 */
@Embeddable
public class Address {

    private String street;
    private String city;
    private String state;
    private String pincode;

    public Address() {
    }

    public Address(String street, String city, String state, String pincode) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }
}
