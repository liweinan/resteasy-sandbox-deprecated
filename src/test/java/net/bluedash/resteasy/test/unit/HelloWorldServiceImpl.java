package net.bluedash.resteasy.test.unit;

public class HelloWorldServiceImpl implements HelloWorldService {
    public static final String HELLO_WORLD = "Hello, world!";

    public String printHelloWorld() {
        return HELLO_WORLD;
    }
}

