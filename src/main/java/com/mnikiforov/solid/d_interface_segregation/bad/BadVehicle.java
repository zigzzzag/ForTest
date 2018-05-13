package com.mnikiforov.solid.d_interface_segregation.bad;

@SuppressWarnings({"SameReturnValue", "unused"})
interface BadVehicle {

    String drive();

    String fly();

    String swim();
}
