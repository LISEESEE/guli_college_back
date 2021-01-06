package com.lss.study.concurrent.c7;

public class SynchronizedRunnable implements Runnable {
    private int index = 1;
    //只读共享数据
    private final static int MAX = 500;

    //this
    @Override
    public void run() {
        while (true) {
            if (ticket()) {
                break;
            }
        }
    }

    //    private synchronized boolean ticket() {
//        if (index>MAX){
//            return true;
//        }
//        try {
//            Thread.sleep(5);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
//        return false;
//    }
    private boolean ticket() {
        synchronized (this) {

            if (index > MAX) {
                return true;
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread() + " 的号码是:" + (index++));
            return false;
        }
    }
}
