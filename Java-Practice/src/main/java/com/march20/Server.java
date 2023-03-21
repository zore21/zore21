package com.march20;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    // initialize socket and input stream

    private Socket socket = null;
    private ServerSocket serverSocket = null;
    private DataInputStream inputStream = null;

    public Server(int port){
        // starts server and waits for a connection
        try{
            serverSocket = new ServerSocket(port);
            System.out.println("Server started");

            System.out.println("Waiting for a client ....");

            socket = serverSocket.accept();
            System.out.println("Client accepted");

            // takes input from the client socket
            inputStream = new DataInputStream(
                    new BufferedInputStream(socket.getInputStream())
            );

            String line = "";

            //reads message from client until "bye" is sent
            while (!line.equals("bye")){
                try{
                    line = inputStream.readUTF();
                    System.out.println(line);
                }catch (IOException e){
                    e.printStackTrace();
                }
            }

            System.out.println("Closing connection...");

            // close connection

            socket.close();
            inputStream.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server server = new Server(5000);
    }
}
