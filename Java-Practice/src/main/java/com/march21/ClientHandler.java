package com.march21;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ClientHandler extends Thread{
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    DateFormat timeFormat = new SimpleDateFormat("hh:mm:ss");

    final DataInputStream dataInputStream;

    final DataOutputStream dataOutputStream;

    final Socket socket;

    public ClientHandler(Socket socket,
                         DataInputStream dataInputStream,
                         DataOutputStream dataOutputStream){

        this.socket = socket;
        this.dataInputStream = dataInputStream;
        this.dataOutputStream = dataOutputStream;

    }

    @Override
    public void run() {

        String received ;
        String to_return;

        while (true)
        {
            try{
//                Ask user what he wants
                dataOutputStream.writeUTF(
                        "What do you want?[Date | Time]..\n"+
                                "Type Exit to terminate connection."
                );

                received = dataInputStream.readUTF();

                if(received.equals("Exit")){
                    System.out.println("Client "+this.socket+" sends exit...");
                    System.out.println("Closing this connection.");
                    this.socket.close();
                    System.out.println("Connection closed");
                    break;
                }

//                creating Date Object

                Date date = new Date();

//                write on output stream based on the
//                        answer from the client

                switch (received){
                    case "Date":
                        to_return = dateFormat.format(date);
                        dataOutputStream.writeUTF(to_return);
                        break;

                    case "Time":
                        to_return = timeFormat.format(date);
                        dataOutputStream.writeUTF(to_return);
                        break;

                    default:
                        dataOutputStream.writeUTF("Invalid input");
                        break;
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
        try{
            this.dataInputStream.close();
            this.dataOutputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
