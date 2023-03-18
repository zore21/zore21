package com.march18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileIODemo005{
    public static void main(String[] args) throws Exception{

        DataInputStream dataInputStream =
                new DataInputStream(new FileInputStream("file.txt"));

        DataOutputStream dataOutputStream =
                new DataOutputStream(new FileOutputStream("file2.txt"));

        String string = " ";
        while (!string.equals("stop")){
            string = dataInputStream.readLine();
            if(string != null)
                System.out.println(string);

            dataOutputStream.writeUTF(string);
            dataOutputStream.flush();
        }

    }
}
