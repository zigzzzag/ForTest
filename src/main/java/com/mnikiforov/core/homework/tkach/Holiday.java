package com.mnikiforov.core.homework.tkach;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zigzzzag on 24.07.2015.
 */
public class Holiday implements Comparable<Holiday> {

    private String name;
    private Date date;

    public Holiday(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    @Override
    public int compareTo(Holiday o) {
        return date.compareTo(o.getDate()) != 0 ? date.compareTo(o.getDate()) :
                name.compareTo(o.getName());
    }

    @Override
    public String toString() {
        return new SimpleDateFormat("dd.MM.yyyy").format(date) + " " + name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
