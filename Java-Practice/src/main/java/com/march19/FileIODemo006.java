package com.march19;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

//demo of PrintStrean
public class FileIODemo006 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream =
                new PrintStream(new FileOutputStream("file3.txt"));

        printStream.println("Hello how are you?");
    }
}
