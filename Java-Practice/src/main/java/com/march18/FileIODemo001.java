package com.march18;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIODemo001 {
    public static void main(String[] args) {
        try {
            FileOutputStream flieout = new FileOutputStream("abc.txt");
//            String string = "Hello world!! How are you ?";

            String string = JOpti   onPane.showInputDialog(null,
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
