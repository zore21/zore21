package com.march18;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;


/*
FileInputStream and FileOutputStream demo code
text is taken input from a JoptionPane dialog
box and then put it in a file with FileOutputStream
and then read it with FileInputStream and print it
        on console
*/


public class FileIODemo001 {
    public static void main(String[] args) {
        try {
            FileOutputStream flieout = new FileOutputStream("abc.txt");
//            String string = "Hello world!! How are you ?";

            String string = JOptionPane.showInputDialog(null,
                    "Enter message here ");

            byte[] bytes = string.getBytes();
            flieout.write(bytes);

            FileInputStream finput = new FileInputStream("abc.txt");
            while (true){
                int i = finput.read();
                if(i == -1)
                    break;

                System.out.print((char)i);
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
