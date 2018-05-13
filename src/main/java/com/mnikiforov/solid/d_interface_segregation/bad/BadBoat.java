package com.mnikiforov.solid.d_interface_segregation.bad;

@SuppressWarnings("unused")
class BadBoat implements BadVehicle {

    @Override
    public String drive() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String swim() {
        return "Boat swim";
    }
}
