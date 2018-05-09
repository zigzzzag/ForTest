package com.mnikiforov.solid.b_open_closed.good;

class GoodGreeting {

    private static final Greeter DEFAULT_GREETER = new GreeterRU();

    private final Greeter greeter;

    GoodGreeting() {
        this.greeter = DEFAULT_GREETER;
    }

    GoodGreeting(Greeter greeter) {
        this.greeter = greeter;
    }

    String greet() {
        return greeter.helloWorld();
    }
}
