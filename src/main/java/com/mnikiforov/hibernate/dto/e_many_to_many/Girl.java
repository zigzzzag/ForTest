package com.mnikiforov.hibernate.dto.e_many_to_many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by Zigzag on 25.11.2015.
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @ManyToMany(mappedBy = "girls")
    private Collection<UserWithManyToMany> mans = new ArrayList<>();

    public Girl() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<UserWithManyToMany> getMans() {
        return mans;
    }

    public void setMans(Collection<UserWithManyToMany> mans) {
        this.mans = mans;
    }

    public int getId() {
        return id;
    }
}
