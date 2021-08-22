package com.fyzheng.chapter1;

/**
 * @author fyzheng
 * @create 2021-08-21 22:26
 * @Description:
 * 清单1 - 2
 */
public class JavaThreadCreateAndRun {
    public static void main(String[] args) {
        System.out.println("This main method was executed by thread:" + Thread.currentThread().getName());
        Helper helper = new Helper("Java Thread Anywhere");

        //创建一个线程
        Thread thread = new Thread(helper);
        //设置名字
        thread.setName("A-Worder-Thread");
        //启动线程
        thread.start();//doSomething方法由thread执行
        //下面两种都是由main执行
//        thread.run();
//        helper.run();

    }

    static class Helper implements Runnable {
        private final String message;

        public Helper(String message) {
            this.message = message;
        }

        private void doSomething(String message) {
            System.out.println("The doSomething method was executed by thread:" + Thread.currentThread().getName());
            System.out.println("Do Something with:" + message);
        }

        @Override
        public void run() {
            doSomething(message);
        }
    }
}
