package com.mnikiforov.solid.e_dependency_inversion.good;

public class GoodEclipse implements GoodIde {

    @Override
    public void desc(String ideName) {
        if ("eclipse".equals(ideName)) {
            System.out.println("Eclipse is a best ide");
        }
    }
}
