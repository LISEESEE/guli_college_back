package com.lss.study.concurrent.c10;

public class SynchronizedProblem {

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> run()).start();

        Thread.sleep(1000);

        Thread t2 = new Thread(() -> {
//                /sdfsdfsd
            run();
            //sdfsdfsd
        });
        t2.start();
        Thread.sleep(2000);
        t2.interrupt();
        System.out.println(t2.isInterrupted());
    }

    private synchronized static void run() {
        System.out.println(Thread.currentThread());
        while (true) {

        }
    }
}
