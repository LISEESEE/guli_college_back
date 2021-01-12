package com.lss.study.concurrent01.c7;

public class SynchronizedThis {
    public static void main(String[] args) {
        ThisLock thisLock = new ThisLock();
        new Thread(()-> thisLock.m1()).start();
        new Thread(()->thisLock.m2()).start();
    }
}
class ThisLock{
    private final Object LOCK = new Object();
    public void m1(){
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void m2(){
        synchronized (this){
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
