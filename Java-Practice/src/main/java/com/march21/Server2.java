package com.march21;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

//java implementation of server side
//It contains two classes : Server2 and ClientHandler
//save file as Server2.java

//Server class
public class Server2 {
    public static void main(String[] args) throws IOException {
//      server is listening on port 5056
        ServerSocket serverSocket = new ServerSocket(5056);

//        running infinite loop for getting
//                client request
        while(true){

            Socket socket = null;

            try{
//                socket object to receive client request
                socket = serverSocket.accept();

                System.out.println("A new client is connected : "+socket);

//                obtaining input and out streams

                DataInputStream dataInputStream = new DataInputStream(
                        socket.getInputStream()
                );

                DataOutputStream dataOutputStream = new DataOutputStream(
                        socket.getOutputStream()
                );

                System.out.println("Assigning new thread for this client");

//                obtaining input and out streams
                Thread thread = new ClientHandler(socket,
                        dataInputStream, dataOutputStream);

                thread.start();

            }catch (Exception e){
                socket.close();
                e.printStackTrace();
            }

        }

    }
}
