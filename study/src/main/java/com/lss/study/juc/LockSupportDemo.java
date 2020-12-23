package com.lss.study.juc;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * synchronized
 * 1、wait()和notify()不能脱离同步代码块 IllegalMonitorStateException
 * 2、将notify()放在wait()前面，程序无法执行，无法唤醒
 * lock
 * 1、await()和signal()不能脱离lock，即线程要先获得并持有锁，必须在锁块中
 * 2、必须先等待后唤醒，线程才能被唤醒
 *
 * LockSupport
 * 为什么可以先唤醒线程后阻塞线程？
 * 因为unpark()获得了一个凭证，之后再调用park()方法，就可以名正言顺的凭证消费，故不会阻塞
 *
 * 为什么唤醒两次后阻塞两次，但最终结果还是会阻塞线程？
 * 因为凭证的数量最多为1，连续调用两次unpark()和调用一次unpark()效果一样，只会增加一个凭证；
 * 而调用两次park却需要消耗两个凭证，证不够，不能放行。
 */
public class LockSupportDemo {
    static Object objectLock = new Object();
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();

    public static void main(String[] args) {
        Thread a = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "..come in");
            LockSupport.park();//被阻塞
            System.out.println(Thread.currentThread().getName() + "..被唤醒");
        },"a");
        a.start();

        Thread b = new Thread(() -> {
            LockSupport.unpark(a);
            System.out.println(Thread.currentThread().getName() + "..通知");
        },"b");
        b.start();
    }

    private static void lockAwaitSignal() {
        new Thread(() -> {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName() + "..come in");
                try {
                    condition.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "..被唤醒");
            } finally {

                lock.unlock();
            }
        }, "A").start();
        new Thread(() -> {
            lock.lock();
            try {
                condition.signal();
                System.out.println(Thread.currentThread().getName() + "..通知");
            } finally {
                lock.unlock();
            }
        }, "B").start();
    }

    private static void synchronizedWaitNotify() {
        new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objectLock) {
                System.out.println(Thread.currentThread().getName() + "..come in");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "..被唤醒");
            }
        }, "A").start();
        new Thread(() -> {
            synchronized (objectLock) {
                objectLock.notify();
                System.out.println(Thread.currentThread().getName() + "..通知");
            }
        }, "B").start();
    }
}
