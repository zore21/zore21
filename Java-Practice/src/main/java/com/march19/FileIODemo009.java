package com.march19;

/*fileiodemo with FileWriter and FileReader
FilwWriter uses character stream
which helps writing and reading
files of files with various character
schema like with different languages.*/

// here demo of FileWriter

import java.io.FileWriter;
import java.io.IOException;

public class FileIODemo009 {
    public static void main(String[] args) throws IOException {

        FileWriter fileWriter = new FileWriter("file7.txt");
        String string = "Hi My name is Prathamesh zore";
        char[] ch = string.toCharArray();
//        fileWriter.write(ch); // whole character array gets written here
        for(int i = 0; i < ch.length; i++){
            fileWriter.write(ch[i]);
        }

        fileWriter.close();
    }
}
