package com.march19.socket_programming;

import java.io.DataInputStream;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    public static void main(String[] args) {
        try{
            ServerSocket serverSocket = new ServerSocket(2000);
            System.out.println("Server is starting...." +
                    "and waiting for client request...");
            Socket socket = serverSocket.accept();
            System.out.println(socket);
            InputStream inputStream =
                    socket.getInputStream();
            DataInputStream dataInputStream =
                    new DataInputStream(inputStream);
            String message = (String) dataInputStream.readUTF();
            System.out.println(message);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
