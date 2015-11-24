package com.mnikiforov.hibernate.dto.collections;

import com.mnikiforov.hibernate.dto.embedding_objects.Address;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sbt-nikiforov-mo on 24.11.15.
 */
@Entity
public class UserWithCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;

    @ElementCollection
    private Set<Address> listOfAddresses = new HashSet<>();

    public UserWithCollection() {
    }

    public int getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Set<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }
}
