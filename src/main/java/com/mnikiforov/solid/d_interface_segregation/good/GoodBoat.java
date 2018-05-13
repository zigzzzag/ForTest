package com.mnikiforov.solid.d_interface_segregation.good;

@SuppressWarnings("unused")
class GoodBoat implements Swimming {

    @Override
    public String swim() {
        return "Boat swim";
    }
}
