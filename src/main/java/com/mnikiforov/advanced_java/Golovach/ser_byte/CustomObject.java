package com.mnikiforov.advanced_java.Golovach.ser_byte;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * Created by zigzzzag on 12.08.2015.
 */
public class CustomObject implements Externalizable {

    boolean b;

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeBoolean(b);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        in.readBoolean();
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    public static void main(String[] args) {
        CustomObject co = new CustomObject();
        System.out.println(co);
    }
}
