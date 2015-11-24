package com.mnikiforov.hibernate.dto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

/**
 * Created by sbt-nikiforov-mo on 12.11.15.
 * <p/>
 *
 * @Table(name = "USER_DETAILS2")
 * не работало с
 * <groupId>org.hibernate.javax.persistence</groupId>
 * <artifactId>hibernate-jpa-2.1-api</artifactId>
 * <version>1.0.0.Final</version>
 */
@Entity
@Table(name = "USER_DETAILS")
public class UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;

    private String email;

    @Temporal(value = TemporalType.DATE)
    private Date joinedDate;

    @Embedded
    private Address address;

    @Lob
    private String description;

    public UserDetails() {
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

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
