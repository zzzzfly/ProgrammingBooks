package com.fyzheng.chapter1;

/**
 * @author fyzheng
 * @create 2021-08-21 22:04
 * @Description:
 * 第一章---清单 1 - 1
 */
public class JavaThreadAnyWhere {

    public static void main(String[] args) {
        System.out.println("This main method was executed by thread:" + Thread.currentThread().getName());
        Helper helper = new Helper("Java Thread Anywhere");
        helper.run();
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
