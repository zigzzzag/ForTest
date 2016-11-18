package com.mnikiforov.hibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * Created by Zigzag on 19.11.2016.
 */
@Entity
@Table(name = "OTOA_passports")
public class Passport {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(mappedBy = "passport")
    private User user;

    @Column(name = "serial")
    private String serial;

    public Passport() {
    }

    public Passport(String serial) {
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public String toString() {
        return "Passport{" +
                "id=" + id +
                ", serial='" + serial + '\'' +
                '}';
    }
}
