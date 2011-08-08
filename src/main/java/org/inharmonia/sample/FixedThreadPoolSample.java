package org.inharmonia.sample;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Hello world!
 *
 */
public class FixedThreadPoolSample {

    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(10); // this is our thread pool with 10 threads standing by
        for (int i = 0; i < 20; i++) {
            final int n = i;
            es.submit(new Runnable() {

                public void run() {
                    try {
                        final long sleeptime = Math.round(Math.random() * 1000) % 10 * 1000;
                        System.out.println("Thread "+ n + " waiting for : " + sleeptime);
                        Thread.sleep(sleeptime);
                        System.out.println("Thread "+ n + " done!");
                    } catch (InterruptedException ex) {
                        Logger.getLogger(FixedThreadPoolSample.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
        }
        es.shutdown();
    }
}
