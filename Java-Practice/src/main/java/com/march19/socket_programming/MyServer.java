package com.march19.socket_programming;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
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

            String messageBack = JOptionPane.showInputDialog(null,"Message back ");
            OutputStream outputStream = socket.getOutputStream();
            DataOutputStream dataOutputStream =
                    new DataOutputStream(outputStream);
            dataOutputStream.writeUTF(messageBack);
            dataOutputStream.flush();
            dataOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
