package com.mnikiforov.advanced_java.Golovach.ser_byte;

import org.apache.commons.lang.builder.ToStringBuilder;

import java.io.IOException;
import java.io.Serializable;

/**
 * Created by zigzzzag on 12.08.2015.
 */
public class DataObject extends NonSerializable implements Serializable {

    private static final long serialVersionUID = 1L;
    int i = 10;
    String s = "testStr";
    String[] def = new String[]{"11", "22", "33"};
    CustomObject customObject = new CustomObject();

    private void writeObject(java.io.ObjectOutputStream stream) throws IOException {
        stream.defaultWriteObject();//always call
        stream.writeObject(getMyData());
    }

    private void readObject(java.io.ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        setMyData((String) stream.readObject());//always call
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
//        StringBuilder sb = new StringBuilder(this.getClass().getSimpleName()).append(":").append(Constants.NEW_LINE);
//        for (Field field : this.getClass().getDeclaredFields()) {
//            try {
//                sb.append(field.getName())
//                        .append("(").append(field.getType()).append(")")
//                        .append("=").append(field.get(this)).append(";")
//                        .append(Constants.NEW_LINE);
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            }
//        }
//        return sb.toString();
    }

    public static void main(String[] args) {
        DataObject dataObject = new DataObject();
        dataObject.setMyData("111");
        dataObject.setCustomObject(new CustomObject());
        System.out.println(dataObject);
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getS() {
        return s;
    }

    public void setS(String s) {
        this.s = s;
    }

    public String[] getDef() {
        return def;
    }

    public void setDef(String[] def) {
        this.def = def;
    }

    public CustomObject getCustomObject() {
        return customObject;
    }

    public void setCustomObject(CustomObject customObject) {
        this.customObject = customObject;
    }
}
