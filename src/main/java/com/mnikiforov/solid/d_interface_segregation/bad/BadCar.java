package com.mnikiforov.solid.d_interface_segregation.bad;

@SuppressWarnings("unused")
class BadCar implements BadVehicle {

    @Override
    public String drive() {
        return "Car drive";
    }

    @Override
    public String fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String swim() {
        throw new UnsupportedOperationException();
    }
}
