package org.example;

import java.util.ArrayList;
import java.util.List;

public class EasyThreadSumGenerator {
    private int sum;

    private List<Thread> threads;
    private List<Integer> items;
    private int parts;
    private int pointer;

    public EasyThreadSumGenerator(List<Integer> items, int parts, int cThreads) {
        this.items = items;
        threads = new ArrayList<>();
        this.parts = parts;
        sum = 0;
        pointer = 0;


        for(int i = 0; i < Math.min(cThreads, items.size() / parts + (items.size() % parts != 0 ? 1 : 0)); i++) {
            int p = pointer + items.size()/parts;
            threads.add(new EasyThreadSum(items, pointer, (p >= items.size() ? items.size() - 1 : p)));

            pointer = p;
        }
    }

    public void run() {
        int i = 0;

        for(var j : threads) {
            j.start();
        }

        while(pointer < items.size()) {
            Thread th = threads.get(i);
            if(!th.isAlive()) {
                sum += ((EasyThreadSum) th).getSum();

                int p = pointer + items.size()/parts;

                threads.set(i, new EasyThreadSum(items, pointer, (p >= items.size() ? items.size() - 1 : p)));

                threads.get(i).start();

                pointer = p;
            }
            i ++;
            if(i >= threads.size()) {
                i = 0;
            }
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
    }
}
