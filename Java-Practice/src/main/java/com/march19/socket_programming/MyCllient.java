package com.march19.socket_programming;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyCllient {
    public static void main(String[] args) {
        try{
            Socket socket = new Socket(
                    "localhost",2000);
            System.out.println(socket);

            OutputStream outputStream =
                    socket.getOutputStream();
            DataOutputStream dataOutputStream =
                    new DataOutputStream(outputStream);

            String message = JOptionPane.showInputDialog(null,"Enter message here ");

            dataOutputStream.writeUTF(message);
            dataOutputStream.flush();
            dataOutputStream.close();

            InputStream inputStream =
                    socket.getInputStream();
            DataInputStream dataInputStream =
                    new DataInputStream(inputStream);
            String messageBack = (String) dataInputStream.readUTF();
            System.out.println(messageBack);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
