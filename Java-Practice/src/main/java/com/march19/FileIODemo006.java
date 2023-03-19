package com.march19;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

//demo of PrintStrean
public class FileIODemo006 {
    public static void main(String[] args) throws FileNotFoundException {
        PrintStream printStream =
                new PrintStream(new FileOutputStream("file4.txt"));

        // by default out is the static final varible
        // of System class whose type is PrintStream
        // by default it gives output on console
        // but this can change by using setOut()
        // method we can provide where should the
        // output prints


        System.setOut(printStream);
        System.out.println("Hi Hello this is PrintStream demo " +
                "this is printing on a different file not on " +
                "console");



    }
}
