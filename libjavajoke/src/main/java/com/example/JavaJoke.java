package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JavaJoke {

    private final Random random;
    private final List<String> jokes;

    public JavaJoke() {
        this.random = new Random();
        this.jokes = new ArrayList<>();
        jokes.add("joke1");
        jokes.add("joke2");
        jokes.add("joke3");
    }

    public String tellJoke() {
        return jokes.get(random.nextInt(jokes.size()));
    }

}
