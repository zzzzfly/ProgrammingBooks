package com.fyzheng.chapter1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author fyzheng
 * @create 2021-08-21 22:26
 * @Description:
 */
public class WorkerThread {
    public static void main(String[] args) {
        Helper helper = new Helper();
        helper.init();

        helper.submit("Something...");
    }

    static class Helper {
        private final BlockingQueue<String> workQueue = new ArrayBlockingQueue<String>(100);
        private final Thread workerThread = new Thread() {
            @Override
            public void run() {
                String task = null;
                while (true) {
                    try {
                        task = workQueue.take();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        break;
                    }
                    System.out.println(doProcess(task));
                }
            }
        };

        protected String doProcess(String task) {
            return task + "-> processed.";
        }

        public void init() {
            workerThread.start();
        }

        public void submit(String task) {
            try {
                workQueue.put(task);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
    }
}
