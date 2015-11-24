package com.mnikiforov.hibernate.dto.a_embedding_objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * Created by sbt-nikiforov-mo on 24.11.15.
 */
@Embeddable
public class Address {

    @Column(name = "STREET_NAME")
    private String street;

    @Column(name = "CITY_NAME")
    private String city;

    @Column(name = "STATE_NAME")
    private String state;

    @Column(name = "PIN_CODE")
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
