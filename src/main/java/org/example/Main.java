package org.example;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class Main {
    public static void main(String[] args) {
        try (
                final ServerSocket serverSocket = new ServerSocket(9999);
        ) {
            while (true) {
                try {
                    final Socket socket = serverSocket.accept();
                    
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    final OutputStream outputStream = socket.getOutputStream();

                    String line;
                    while ((line = reader.readLine()) != null) {
                        System.out.println("line = " + line);
                        outputStream.write(line.getBytes(StandardCharsets.UTF_8));
                        outputStream.flush();


                    }

                    socket.close(); // FIXME: in real app

                } catch (Exception e) {

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
