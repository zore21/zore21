package com.march19;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.FileWriter;
import java.io.IOException;

//FileIODemo with CharacterArrayWriter
public class FileIODemo011 {

    public static void main(String[] args) throws IOException {

        CharArrayWriter charArrayWriter = new CharArrayWriter();
        String string = "Hello I'm prathamesh and this is file8 may be";

        char[] ch = string.toCharArray();
        charArrayWriter.write(ch);

        charArrayWriter.writeTo(new FileWriter("file8.txt"));
        System.out.println(charArrayWriter.toString());

        char[] chars = charArrayWriter.toCharArray();
        CharArrayReader charArrayReader = new CharArrayReader(chars);

        int i = 0;
        while((i=charArrayReader.read()) != -1){
            System.out.println((char)i);
        }

    }
}