package com.mnikiforov.hibernate.dto.d_one_to_many;

import com.mnikiforov.hibernate.dto.common.Vehicle;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;

/**
 * Created by sbt-nikiforov-mo on 24.11.15.
 */
@Entity
@Table(name = "D01_USER_WITH_ONE_TO_MANY")
public class UserWithOneToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;

    @OneToMany
    @JoinTable(name = "D_USER_VEHICLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "VEHICLE_ID"))
    private Collection<Vehicle> vehicle = new ArrayList<>();

    public UserWithOneToMany() {
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

    public Collection<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(Collection<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }
}
