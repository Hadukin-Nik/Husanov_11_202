package org.example;

public class DeadLockExample {
    public DeadLockExample() {
        BonusCard b1 = new BonusCard(150);
        BonusCard b2 = new BonusCard(120);

        DeadLockThread th1 = new DeadLockThread(b1, b2);
        DeadLockThread th2 = new DeadLockThread(b2, b1);

        th1.start();
        th2.start();
    }
}
