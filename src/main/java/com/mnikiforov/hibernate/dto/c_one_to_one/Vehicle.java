package com.mnikiforov.hibernate.dto.c_one_to_one;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by sbt-nikiforov-mo on 25.11.15.
 */
@Entity
@Table(name = "c02_vehicle")
public class Vehicle {

    @Id
    @GeneratedValue
    private int vehicleId;
    private String vehicleName;

    public int getVehicleId() {
        return vehicleId;
    }

    public String getVehicleName() {
        return vehicleName;
    }

    public void setVehicleName(String vehicleName) {
        this.vehicleName = vehicleName;
    }
}
