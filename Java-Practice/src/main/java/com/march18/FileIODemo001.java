package com.march18;

import java.io.FileOutputStream;

public class FileIODemo001 {
    public static void main(String[] args) {
        try {
            FileOutputStream flieout =
                    new FileOutputStream("abc.txt");
            String string = "Hello world!! How are you ?";
            byte[] bytes = string.getBytes();
            flieout.write(bytes);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
