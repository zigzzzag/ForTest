package com.mnikiforov.advanced_java.generics.BoundedTypeParameters;

/**
 * Created by SBT-Nikiforov-MO on 03.08.2015.
 */
public class Phone extends Product<Phone> {

    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    void subCompare(Phone phone) {
        //todo something
    }
}
