package com.march21;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.Socket;

//transferring file from Client socket to Server socket

public class Client {

    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    public static void main(String[] args) {
//        create client socket connect to port 5000
        try(Socket socket = new Socket("localhost", 5000)){
            dataInputStream = new DataInputStream(
             socket.getInputStream()
            );

            dataOutputStream = new DataOutputStream(
                    socket.getOutputStream()
            );

            System.out.println("Sending the file to the server");
//            call sendFile method
            sendFile("out1.pdf");

            dataInputStream.close();
            dataOutputStream.close();

        }catch(Exception e){
            e.printStackTrace();
        }
    }

//    sendFile function
    private static void sendFile(String path) throws Exception{

        int bytes = 0;
//        open file where it is located in your files explorer
        File file = new File(path);
        FileInputStream fileInputStream =
                new FileInputStream(file);

//        Here we send the file to the server
        dataOutputStream.writeLong(file.length());

        byte[] buffer = new byte[4 * 1024];
//        here we break file into chunks
        while ((bytes = fileInputStream.read(buffer)) != -1){
//            send the file to server socket
            dataOutputStream.write(buffer, 0, bytes);
            dataOutputStream.flush();
        }
//        close the file here
        dataOutputStream.close();
    }
}