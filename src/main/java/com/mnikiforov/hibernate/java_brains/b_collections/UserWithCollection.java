package com.mnikiforov.hibernate.java_brains.b_collections;

import com.mnikiforov.hibernate.java_brains.a_embedding_objects.Address;
import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by zigzzzag on 24.11.15.
 */
@Entity
@Table(name = "B01_USER_WITH_COLLECTION_ADDRESS")
public class UserWithCollection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;

    @ElementCollection(fetch = FetchType.EAGER)
    @JoinTable(name = "B02_USER_ADDRESS",
            joinColumns = @JoinColumn(name = "USER_ID")
    )
    @GenericGenerator(name = "sequence-gen", strategy = "sequence")
    @CollectionId(columns = {@Column(name = "ADDRESS_ID")},
            generator = "sequence-gen",
            type = @Type(type = "long"))
    private Collection<Address> listOfAddresses = new ArrayList<>();

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

    public Collection<Address> getListOfAddresses() {
        return listOfAddresses;
    }

    public void setListOfAddresses(Collection<Address> listOfAddresses) {
        this.listOfAddresses = listOfAddresses;
    }
}
