package com.mnikiforov.solid.d_interface_segregation.good;

@SuppressWarnings("unused")
class GoodAircraft implements Flying {

    @Override
    public String fly() {
        return "Aircraft fly";
    }
}
