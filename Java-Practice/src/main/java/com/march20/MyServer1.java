package com.march20;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer1 {

    ServerSocket serverSocket ;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;

    public MyServer1(){
        try{
            System.out.println("Server started...");
            serverSocket = new ServerSocket(2000);
            socket = serverSocket.accept();
            System.out.println("Client connected!");
            dataInputStream = new DataInputStream(
              socket.getInputStream()
            );
            dataOutputStream = new DataOutputStream(
                    socket.getOutputStream()
            );

            serverchat();

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void serverchat() {
    }

    public static void main(String[] args) {

    }
}
