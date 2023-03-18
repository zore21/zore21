package com.march18;


/*
BufferedInputStream and BufferedOutputStream demo
*/

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIODemo3 {
    public static void main(String[] args) {
        try {

            FileOutputStream fileOutputStream =
                    new FileOutputStream("abcd3.txt");

            BufferedOutputStream bufferedOutputStream =
                    new BufferedOutputStream(fileOutputStream);

            String message = JOptionPane.showInputDialog(null,
                    "Enter message here");
            byte[] bytes = message.getBytes();
            bufferedOutputStream.write(bytes);

            System.out.println("File created successfully");

            FileInputStream fileInputStream =
                    new FileInputStream("abcd3.txt");

            BufferedInputStream bufferedInputStream =
                    new BufferedInputStream(fileInputStream);

            while(true){
                int i = bufferedInputStream.read();
                if(i==-1)
                    break;
                System.out.print((char)i);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
