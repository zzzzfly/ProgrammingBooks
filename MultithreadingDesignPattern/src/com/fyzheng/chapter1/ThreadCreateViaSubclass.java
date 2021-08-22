package com.fyzheng.chapter1;

/**
 * @author fyzheng
 * @create 2021-08-21 23:19
 * @Description:
 * 清单 1-3
 */
public class ThreadCreateViaSubclass {
    public static void main(String[] args) {
        Thread thread = new CustomThread();
        thread.start();

    }
    static class CustomThread extends Thread {
        @Override
        public void run() {
            System.out.println("runing...");
        }
    }
    /**
     * 上下文切换
     *
     * 可通过perf命令来监视
     * perf stat -e cpu-clock, task-clock, cs, cache-references, cache-misses, java
     */
}
