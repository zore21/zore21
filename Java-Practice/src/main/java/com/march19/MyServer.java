package com.march19;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/*
demo of ObjectInputStream
object will be passed to objectinputstream
at server side
*/
public class MyServer {

    ObjectInputStream objectInputStream;

    public MyServer() {
        try{
            objectInputStream = new ObjectInputStream(
                    new FileInputStream("file5.txt")
            );
            Employee employee = (Employee) objectInputStream.readObject();
            System.out.println(employee);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyServer();
    }
}
