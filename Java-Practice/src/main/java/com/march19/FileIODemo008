package com.march19;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

//PipedOutputStream demo

class PipedOut implements  Runnable{
    PipedOutputStream pipedOutputStream;

    public PipedOut(PipedOutputStream pipedOutputStream) {
        this.pipedOutputStream = pipedOutputStream;
    }

    public void run() {
        for(int i = 65; i <= 91; i++){
            try{
                pipedOutputStream.write(i);
                Thread.sleep(1000);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }
}

class PipedIn implements Runnable{

    PipedInputStream pipedInputStream;

    public PipedIn(PipedInputStream pipedInputStream) {
        this.pipedInputStream = pipedInputStream;
    }

    public void run() {
        int z = 0;

        for(int i = 65; i <= 91; i++) {
            try {
                z = pipedInputStream.read();
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println((char) z);
        }
    }
}

public class FileIODemo008 {
    public static void main(String[] args) throws IOException {
        PipedOutputStream pipedOutputStream = new PipedOutputStream();
        PipedInputStream pipedInputStream = new PipedInputStream();
        pipedOutputStream.connect(pipedInputStream);

        PipedOut pipedOut = new PipedOut(pipedOutputStream);
        PipedIn pipedIn = new PipedIn(pipedInputStream);

        Thread thread1 = new Thread(pipedOut);
        Thread thread2 = new Thread(pipedIn);

        thread1.start();
        thread2.start();

    }
}