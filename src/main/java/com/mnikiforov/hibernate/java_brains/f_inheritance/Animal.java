package com.mnikiforov.hibernate.java_brains.f_inheritance;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Created by sbt-nikiforov-mo on 26.11.15.
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private String voice;

    public Animal() {
    }

    public Animal(String name, String voice) {
        this.name = name;
        this.voice = voice;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVoice() {
        return voice;
    }

    public void setVoice(String voice) {
        this.voice = voice;
    }
}
