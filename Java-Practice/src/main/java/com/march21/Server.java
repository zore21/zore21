package com.march21;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static DataOutputStream dataOutputStream = null;
    private static DataInputStream dataInputStream = null;

    public static void main(String[] args) {
//        here we define server socker running on port 5000
        try(ServerSocket serverSocket = new ServerSocket(5000)){
            System.out.println("Server is starting in port 5000....");
//            Accept the client request using accept method
            Socket socket = serverSocket.accept();
            System.out.println("Connected");

            dataInputStream = new DataInputStream(
                    socket.getInputStream()
            );

            dataOutputStream = new DataOutputStream(
                    socket.getOutputStream()
            );
//            Here we call receiveFile
            reciveFile("NewFile1.pdf");

            dataInputStream.close();
            dataOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void reciveFile(String fileName) throws Exception{
        int bytes = 0;
        FileOutputStream fileOutputStream =
                new FileOutputStream(fileName);
        long size = dataInputStream.readLong(); // read file size
        byte[] buffer = new byte[4 * 1024];
        while(size > 0
                &&
                (bytes = dataInputStream.read(buffer,0, (int)Math.min(buffer.length, size))) != -1){
            //here we write the file using write method
            fileOutputStream.write(buffer, 0, bytes);
            size -= bytes;

        }
        System.out.println("File is Received");
        fileOutputStream.close();
    }
}
