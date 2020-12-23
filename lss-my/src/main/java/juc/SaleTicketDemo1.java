package juc;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Ticket{
    private int number = 30;
    Lock lock = new ReentrantLock();
    public void sale(){
        lock.lock();
        try{
            if (number>0){
                System.out.println(Thread.currentThread().getName()+"卖出第:"+(number--)+"剩余"+number);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
/**
 * 题目：三个售票员   卖出30张票
 * 固定的编程套路+模板
 * 1、在高内聚低耦合的前提下，线程       操作        资源类
 *
 */
public class SaleTicketDemo1 {
    public static void main(String[] args) {
        Ticket ticket  =new Ticket();
        new Thread(()->{ for (int i = 0; i < 10; i++) ticket.sale(); },"AAA").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ticket.sale();
            }
        },"bbb").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                ticket.sale();
            }
        },"ccc").start();
    }
}
