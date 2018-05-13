package com.mnikiforov.solid.d_interface_segregation.bad;

@SuppressWarnings("unused")
class BadAircraft implements BadVehicle {

    @Override
    public String drive() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String fly() {
        return "Aircraft fly";
    }

    @Override
    public String swim() {
        throw new UnsupportedOperationException();
    }
}
