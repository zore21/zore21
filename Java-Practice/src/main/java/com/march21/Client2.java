package com.march21;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {

    public static void main(String[] args) {
        try{
            Scanner scanner = new Scanner(System.in);

//            getting localhost ip
            InetAddress inetAddress =
                    InetAddress.getByName("localhost");

//            establish the connection with server port 5056
            Socket socket = new Socket(inetAddress, 5056);

//            obtaining input and output streams

            DataInputStream dataInputStream =
                    new DataInputStream(socket.getInputStream());

            DataOutputStream dataOutputStream =
                    new DataOutputStream(socket.getOutputStream());

//            the following loop performs the exchange of
//                    information between client and client handler

            while(true){

                System.out.println(dataInputStream.readUTF());
                String to_send = scanner.nextLine();
                dataOutputStream.writeUTF(to_send);

//                If client semds exit, close this connection
//                    and then break from the while loop

                if(to_send.equals("Exit")){

                    System.out.println("Closing the connection : "+socket);
                    socket.close();
                    System.out.println("Connection closed");
                    break;
                }

//                printing date or time as requested by client
                String received = dataInputStream.readUTF();
                System.out.println(received);

            }

//            closing resources

            scanner.close();
            dataInputStream.close();
            dataOutputStream.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
