package com.mnikiforov.solid.e_dependency_inversion.good;

public class GoodIDEResolver {

    private final GoodIde goodIde;

    public GoodIDEResolver(GoodIde goodIde) {
        if (goodIde == null) {
            throw new IllegalArgumentException("GoodIde required");
        }
        this.goodIde = goodIde;
    }


    public void bestIDE(String ideName) {
        goodIde.desc(ideName);
    }
}
