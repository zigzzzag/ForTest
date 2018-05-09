package com.mnikiforov.solid.b_open_closed.good;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GoodGreetingTest {

    @Test
    public void greet() {
        GoodGreeting greeting = new GoodGreeting();
        assertEquals("Привет Мир!", greeting.greet());
    }

    @Test
    public void greetRU() {
        GoodGreeting greeting = new GoodGreeting(new GreeterRU());
        assertEquals("Привет Мир!", greeting.greet());
    }

    @Test
    public void greetEN() {
        GoodGreeting greeting = new GoodGreeting(new GreeterEN());
        assertEquals("Hello World!", greeting.greet());
    }

    @Test
    public void greetFR() {
        GoodGreeting greeting = new GoodGreeting(new GreeterFR());
        assertEquals("Bonjour Monde!", greeting.greet());
    }

    @Test
    public void greetCH() {
        GoodGreeting greeting = new GoodGreeting(new GreeterCH());
        assertEquals("你好世界！", greeting.greet());
    }
}