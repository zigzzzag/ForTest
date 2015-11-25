package com.mnikiforov.hibernate.dto.e_many_to_many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by sbt-nikiforov-mo on 24.11.15.
 */
@Entity
@Table(name = "E01_USER_WITH_MANY_TO_MANY")
public class UserWithManyToMany {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String userName;

    @ManyToMany
    private Collection<Girl> girls = new ArrayList<>();

    public UserWithManyToMany() {
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

    public Collection<Girl> getGirls() {
        return girls;
    }

    public void setGirls(Collection<Girl> girls) {
        this.girls = girls;
    }
}
