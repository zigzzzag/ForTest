package com.mnikiforov.solid.d_interface_segregation.good;

@SuppressWarnings("unused")
class GoodCar implements Driving {

    @Override
    public String drive() {
        return "Car drive";
    }
}
