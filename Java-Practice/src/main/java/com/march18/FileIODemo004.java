package com.march18;

import java.io.*;

/*
DataInput and DataOutputStream demo
DataInput is an abstract class
so other classes implements its logic
DataInputStream is one of them
DataOutputStream takes an low level
 outputstream
*/

public class FileIODemo004 {

    public static void main(String[] args) throws IOException {
        DataInput dataInputStream =
                new DataInputStream(System.in);
        System.out.println("Enter a message : ");
        String data = dataInputStream.readLine();
        System.out.println(data);

        DataOutputStream dataOutputStream =
                new DataOutputStream(new FileOutputStream("file.txt"));

        dataOutputStream.write(data.getBytes());


    }
}
