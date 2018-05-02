package com.mnikiforov.solid.open_closed.bad;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BadGreetingTest {

    @Test
    public void greet() {
        BadGreeting greeting = new BadGreeting();
        assertEquals("Привет Мир!", greeting.greet());

        BadGreeting greetingRU = new BadGreeting("RU");
        assertEquals("Привет Мир!", greetingRU.greet());

        BadGreeting greetingEN = new BadGreeting("EN");
        assertEquals("Hello World!", greetingEN.greet());

        BadGreeting greetingFR = new BadGreeting("FR");
        assertEquals("Bonjour Monde!", greetingFR.greet());

        BadGreeting greetingCH = new BadGreeting("CH");
        assertEquals("你好世界！", greetingCH.greet());
    }
}