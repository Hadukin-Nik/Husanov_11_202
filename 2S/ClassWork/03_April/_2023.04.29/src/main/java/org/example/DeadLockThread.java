package org.example;

public class DeadLockThread extends Thread {
    private BonusCard b1;
    private BonusCard b2;

    public DeadLockThread(BonusCard b1, BonusCard b2) {
        this.b1 = b1;
        this.b2 = b2;
    }

    public void run() {
        for (int i = 0; i < 100; i++) {
            synchronized (b1) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (b2) {
                    b2.use(7);
                }
            }
        }
    }
}
