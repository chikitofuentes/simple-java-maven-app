package com.mycompany.app;

public class MyHandler implements HttpHandler {
   public void handle(HttpExchange t) throws IOException {
       InputStream is = t.getRequestBody();
       read(is); // .. read the request body
       String response = "Hello World!";
       t.sendResponseHeaders(200, response.length());
       OutputStream os = t.getResponseBody();
       os.write(response.getBytes()); os.close();
   }
}