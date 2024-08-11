package com.example.sockets.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.net.URL;

public class PostRequest {

    private static final String JSON = """
        {
          "firstName": "Natan",
          "lastName": "Chachko",
          "age": 18,
          "address": {
            "streetAddress": "Alik",
            "city": "Odesa",
            "state": "Odeska Obl"
          }
        }
        """;

    public static void main(String[] args) throws IOException {
        String request = """
            POST /person HTTP/1.1
            Host: localhost
            Content-Type: application/json
            Content-Length: %d
            Connection: close

            %s""".formatted(JSON.length(), JSON);
        System.out.println("Request:\n" + request);
        try (Socket socket = new Socket("localhost", 8080);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            OutputStream outputStream = socket.getOutputStream();

            outputStream.write(request.getBytes());
            outputStream.flush();
            String responseLine;
            System.out.println("Response:\n");
            while ((responseLine = in.readLine()) != null) {
                System.out.println(responseLine);
            }
            System.out.println("End of response.");
        }
    }
}
