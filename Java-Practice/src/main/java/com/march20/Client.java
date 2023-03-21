package com.march20;

// socket programming in java
// Client program in java

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;

    public Client(String address, int port){
        try {
//            Establish a connection
            socket = new Socket(address, port);
            System.out.println("connected!!!");

//            takes input from terminal
            input = new DataInputStream(System.in);

//            sends output to the socket
            output = new DataOutputStream(
                    socket.getOutputStream()
            );

        }catch (IOException e){
            e.printStackTrace();
            return;
        }
//        string to read message from input
        String line = "";

//        keep reading until "bye" is input

        while(!line.equals("bye")){
            try{
                line = input.readLine();
                output.writeUTF(line);
            }catch(IOException e){
                e.printStackTrace();
            }
        }

//        close the connection
        try{
            input.close();
            output.close();
            socket.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client("localhost",5000);
    }
}