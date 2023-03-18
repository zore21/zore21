package com.march18;

import javax.swing.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIODemo002 {
    public static void main(String[] args) {
        try {
            FileOutputStream fileOutputStream1 =
                    new FileOutputStream("abcd1.txt");
            FileOutputStream fileOutputStream2 =
                    new FileOutputStream("abcd2.txt");

            ByteArrayOutputStream byteArrayOutputStream =
                    new ByteArrayOutputStream();

            String message = JOptionPane.showInputDialog(null,
                    "Enter message here");

            byte bytes[] = message.getBytes();
            byteArrayOutputStream.write(bytes);
            byteArrayOutputStream.writeTo(fileOutputStream1);
            byteArrayOutputStream.writeTo(fileOutputStream2);


            ByteArrayInputStream byteArrayInputStream =
                    new ByteArrayInputStream(bytes);

            //FileInputStream fileInputStream = new FileInputStream("abcd1.txt");
            while(true){
                int i = byteArrayInputStream.read();
                if(i == -1)
                    break;

                System.out.println((char)i);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
