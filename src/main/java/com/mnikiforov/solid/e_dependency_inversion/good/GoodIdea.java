package com.mnikiforov.solid.e_dependency_inversion.good;

public class GoodIdea implements GoodIde {

    @Override
    public void desc(String ideName) {
        if ("idea".equals(ideName)) {
            System.out.println("Idea is a best ide");
        }
    }
}