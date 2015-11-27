package com.mnikiforov.hibernate.dto.f_inheritance;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

/**
 * Created by sbt-nikiforov-mo on 26.11.15.
 */
@Entity@PrimaryKeyJoinColumn(name = "animal_id")
public class Cat extends Animal {

    private String wiskas;

    public Cat() {
    }

    public Cat(String name, String voice, String wiskas) {
        super(name, voice);
        this.wiskas = wiskas;
    }

    public String getWiskas() {
        return wiskas;
    }

    public void setWiskas(String wiskas) {
        this.wiskas = wiskas;
    }
}
