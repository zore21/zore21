package com.march19;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/*
demo of ObjectOutputStream
object will be passed to objectoutputstream
at client side
*/
public class MyClient {

    ObjectOutputStream objectOutputStream;
    public MyClient(){
        try{

            Employee employee =
                    new Employee(1,"Prathamesh", "Java", 30000, "Jr softeare Engineer");
            objectOutputStream = new ObjectOutputStream(
                    new FileOutputStream("file5.txt")
            );
            objectOutputStream.writeObject(employee);
            objectOutputStream.flush();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MyClient();
    }
}
