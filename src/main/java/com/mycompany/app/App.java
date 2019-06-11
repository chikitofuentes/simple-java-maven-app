package com.mycompany.app;

/**
 * Hello world!
 */
public class App
{

    private final String message = "Hello World!";

    public App() {}

    public static void main(String[] args) {
        HttpServer server = HttpServer.create(new InetSocketAddress(8000));
        server.createContext("/applications/myapp", new MyHandler());
        server.setExecutor(null); // creates a default executor
        server.start();
    }

    private final String getMessage() {
        return message;
    }

}
