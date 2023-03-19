package com.march19;

/*SequenceInputStream file io demo
SequenceInputStream represents the logical concatenation
of other input streams. It starts out with an ordered
collection of input streams and reads from the first one
until end of file is reached, where upon it reads from
the second one, and so on, until end of file is reached
on the last of the contained input streams.*/

import java.io.*;

public class FileIODemo007 {
    public static void main(String[] args) throws IOException {

        PrintStream printStream =
                new PrintStream(new FileOutputStream("file3.txt"));
        PrintStream printStream2 =
                new PrintStream(new FileOutputStream("file4.txt"));

        printStream.println("This is file3");
        printStream2.println("This is file4");


        SequenceInputStream sequenceInputStream =
                new SequenceInputStream(
                        new FileInputStream("file3.txt"),
                        new FileInputStream("file4.txt")
                );

        DataInputStream dataInputStream =
                new DataInputStream(sequenceInputStream);

        while(true){
            int i = dataInputStream.read();
            if(i == -1)
                break;
            System.out.print((char)i);
        }
    }
}
