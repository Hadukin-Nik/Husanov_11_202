package org.example;

public class WritingThread extends Thread{
    private final long maxTime = 10000;

    private String message;

    private long lastTimeRecord = 0;

    @Override
    public void start() {
        while(true) {
            if(System.currentTimeMillis() - lastTimeRecord > maxTime) {
                lastTimeRecord = System.currentTimeMillis();

                message = "list";
            }
        }
    }

    public String getMessage() {
        String m = message;

        message = null;

        return  m;
    }
}
