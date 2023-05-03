package org.example;

import java.util.ArrayList;
import java.util.List;

//Class for 2' task


public class SecondEasyThreadGenerator {
    private int sum;

    private List<Thread> threads;
    private List<Integer> items;
    private int pointer;

    public SecondEasyThreadGenerator(List<Integer> items, int cThreads) {
        this.items = items;
        threads = new ArrayList<>();
        sum = 0;
        pointer = 0;


        for(int i = 0; i < cThreads; i++) {
            int p = pointer + items.size()/cThreads;
            threads.add(new EasyThreadSum(items, pointer, (p < items.size() - 1 && i == cThreads - 1 ? items.size() - 1 : p)));

            pointer = p;
        }
    }

    public void run() {
        int i = 0;

        for(var j : threads) {
            j.start();
        }
    }

    public int getSum() {
        for(Thread i : threads) {
            while(i.isAlive());
            if(!i.isAlive()) {
                sum += ((EasyThreadSum) i).getSum();
            }
        }

        return sum;
    }}
