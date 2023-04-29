package org.example;

import java.util.ArrayList;
import java.util.List;

public class EasyThreadGenerator {
    private int m;

    private List<Thread> threads;

    public EasyThreadGenerator(int m) {
        threads = new ArrayList<>();

        for(int i = 1; i <= m; i++) {
            threads.add(new EasyThread(m));
        }
    }

    public void run() {
        for(Thread i : threads) {
            i.start();
        }
    }
}
