package org.example;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class Client {
    public static void main(String[] args) {
        final UUID uuid = UUID.randomUUID();
        try (
                final Socket socket = new Socket("localhost", 9999);
                final OutputStream outputStream = socket.getOutputStream();
        ) {
            while (true) {
                Thread.sleep(5000);
                System.out.println("send message");
                outputStream.write((uuid + "Hello\n").getBytes(StandardCharsets.UTF_8));
                outputStream.flush();
            }

        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
