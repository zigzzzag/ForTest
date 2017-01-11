package com.mnikiforov.hibernate.java_brains.f_inheritance;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by zigzzzag on 26.11.15.
 */
@Entity
@PrimaryKeyJoinColumn(name = "animal_id")
public class Dog extends Animal {

    private String chappy;

    public Dog() {
    }

    public Dog(String name, String voice, String chappy) {
        super(name, voice);
        this.chappy = chappy;
    }

    public String getChappy() {
        return chappy;
    }

    public void setChappy(String chappy) {
        this.chappy = chappy;
    }
}
