package com.mnikiforov.hibernate.dto.collections;

import com.mnikiforov.hibernate.dto.embedding_objects.Address;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by sbt-nikiforov-mo on 24.11.15.
 */
@Entity
@Table(name = "B01_USER_WITH_COLLECTION_ADDRESS")
public class UserWithCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;

    @ElementCollection
    @JoinTable(name = "B02_USER_ADDRESS")
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
