package com.mnikiforov.solid.b_open_closed.bad;

class BadGreeting {

    private static final String DEFAULT_LANG = "RU";

    private final String lang;

    BadGreeting() {
        this.lang = DEFAULT_LANG;
    }

    BadGreeting(String lang) {
        this.lang = lang;
    }

    String greet() {
        if ("RU".equals(lang)) {
            return "Привет Мир!";
        } else if ("EN".equals(lang)) {
            return "Hello World!";
        } else if ("FR".equals(lang)) {
            return "Bonjour Monde!";
        } else if ("CH".equals(lang)) {
            return "你好世界！";
        } else {
            throw new IllegalStateException("Incorrect lang value: " + lang);
        }
    }
}
