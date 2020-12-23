package volatileDemo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Phone implements Runnable{
    public synchronized void sendSMS() throws Exception{
        System.out.println(Thread.currentThread().getId()+"send Sms()");
        sendMail();
    }
    public synchronized void sendMail() throws Exception{
        System.out.println(Thread.currentThread().getId()+"send Mail()");
    }
    Lock lock = new ReentrantLock();
    @Override
    public void run() {
        get();
    }
    public void get(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"执行get");
            set();
        }finally {
            lock.unlock();
        }
    }
    public void set(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"执行set");
        }finally {
            lock.unlock();
        }
    }
}

/**
 * 可重入锁（也叫递归锁）
 * 指的是同一个线程外层函数获得锁之后，内层递归函数仍然能获得该锁的代码，
 * 在同一线程在外层方法获取锁的时候，在进入内层方法会自动获取锁
 *
 * 也就是说，线程可以进入任何一个它已经拥有的锁所同步着的代码块
 * 例子1：sync就是一个典型的可重入锁
 * 12send Sms()     t1线程在外层方法获取锁的时候
 * 12send Mail()    t1在进入内层方法会自动获取锁
 * 13send Sms()
 * 13send Mail()
 *例子2：reentrantLock是一个典型的可重入锁
 */
public class ReenterLockDemo {
    public static void main(String[] args) {
        Phone phone = new Phone();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t1").start();
        new Thread(()->{
            try {
                phone.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        },"t2").start();
        Thread t3 = new Thread(phone,"t3");
        t3.start();
        Thread t4 = new Thread(phone,"t4");
        t4.start();
    }
}
