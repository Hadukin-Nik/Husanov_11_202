package org.example.linkWorkers.hard;

public class DownloadURLsThread extends Thread{
    private LinksForThreadQueue queue;

    public DownloadURLsThread(LinksForThreadQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        synchronized (queue) {
            while(queue.getCountOfFindersInWork() > 0) {
                while(queue.isEmpty()) {
                    try {
                        queue.wait(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }

                ImageProduct p = queue.get();
                DownloadImageThread d = new DownloadImageThread(p.getUrl(), p.getImageReadyPlace());
                System.out.println("Downloaded!: " + p.getImageReadyPlace());
                d.start();
                queue.notifyAll();
                try {
                    d.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
