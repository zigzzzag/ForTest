package com.mnikiforov.solid.e_dependency_inversion.good;

public class GoodNetBeans implements GoodIde {

    @Override
    public void desc(String ideName) {
        if ("netbeans".equals(ideName)) {
            System.out.println("Netbeans is a best ide");
        }
    }
}
