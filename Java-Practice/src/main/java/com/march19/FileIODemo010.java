package com.march19;


//FileIODemo with FileReader

import java.io.FileReader;
import java.io.IOException;

public class FileIODemo010 {

    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader("file7.txt");
        int i = 0;
        while((i = fileReader.read()) != -1)
            System.out.print((char)i);

        fileReader.close();
    }
}
