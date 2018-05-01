package com.mnikiforov.solid.single_responsibility.good;

import java.util.UUID;

public abstract class GoodFigure {

    private final String uuid = UUID.randomUUID().toString();

    String getUuid() {
        return uuid;
    }

    public abstract double area();

    public abstract String draw();
}
