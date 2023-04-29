package org.example.linkWorkers;

public class DownloadURLsThread extends Thread{
    private LinksForThreadQueue queue;

    public DownloadURLsThread(LinksForThreadQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while(queue.countOfFindersInWork > 0) {
            synchronized (queue) {
                while(queue.isEmpty()) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                ImageProduct p = queue.get();
                DownloadImageThread d = new DownloadImageThread(p.getUrl(), p.getImageReadyPlace());
                d.start();
                queue.notify();
            }
        }
    }
}
