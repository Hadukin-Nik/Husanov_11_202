package org.example;

public class EasyThread extends Thread{
    private int m;

    public EasyThread(int m) {
        this.m = m;
    }

    public void run() {
        for(int i =0; i < m; i++) {
            System.out.println(i);
        }
    }
}
