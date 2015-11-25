package com.mnikiforov.hibernate.dto.common;

import com.mnikiforov.hibernate.dto.d_one_to_many.UserWithOneToMany;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Created by sbt-nikiforov-mo on 25.11.15.
 */
@Entity
public class Vehicle {

    @Id
    @GeneratedValue
    private int id;

    private String vehicleName;

    @ManyToOne
    private UserWithOneToMany userMTO;

    public int getId() {
        return id;
    }

    public UserWithOneToMany getUserMTO() {
        return userMTO;
    }

    public void setUserMTO(UserWithOneToMany userMTO) {
        this.userMTO = userMTO;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
