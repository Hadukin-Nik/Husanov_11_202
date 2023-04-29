package org.example;

import java.util.List;

public class EasyThreadSum extends Thread{
    private List<Integer> items;

    private int from, to;

    private int sum;

    public EasyThreadSum(List<Integer> items, int from, int to) {
        this.items = items;

        this.from = from;
        this.to = to;

        sum = 0;
    }

    public void run() {
        for(int i = from; i < to; i++) {
            sum += items.get(i);
        }
    }

    public int getSum() {
        int bSum = sum;

        sum = 0;

        return bSum;
    }

    public void setFromTo(int from, int to) {
        this.from = from;
        this.to = to;

        sum = 0;
    }
}
