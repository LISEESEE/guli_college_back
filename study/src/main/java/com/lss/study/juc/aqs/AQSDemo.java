package com.lss.study.juc.aqs;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * AQS：是用来构建锁或者其它同步器组件的重量级基础框架及整个JUC体系的基石，
 * 通过内置的FIFO队列来完成资源获取线程的排队工作，并通过一个int类型变量
 * 表示持有锁的状态
 */
public class AQSDemo {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        new Thread(()->{
                lock.lock();
            try{
                System.out.println("--------A thread -----");
                try {
                    TimeUnit.MINUTES.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }finally {
                lock.unlock();
            }

        },"A").start();

        new Thread(()->{
            lock.lock();
            try{
                System.out.println("--------b thread -----");
            }finally {
                lock.unlock();
            }

        },"B").start();
        new Thread(()->{
            lock.lock();
            try{
                System.out.println("--------c thread -----");
            }finally {
                lock.unlock();
            }

        },"c").start();
    }

}
