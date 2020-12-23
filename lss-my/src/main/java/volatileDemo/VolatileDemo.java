package volatileDemo;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class MyData{
    volatile int number = 0;
    public void addT060(){
        this.number = 60;
    }
    public void addPlusPlus(){
        number++;
    }
    AtomicInteger atomicInteger = new AtomicInteger();
    public void addMyAtomic(){
        atomicInteger.getAndIncrement();
    }
}

/**
 * 1、验证Volatile的可见性
 *      1.1假如int number =0；number变量之前根本没有添加volatile关键字修饰，没有可见性
 *      1.2添加了volatile，可以解决可见性问题
 * 2、验证volatile不保证原子性
 *      2.1 原子性指的是什么意思？
 *          不可分割，完整性，也即某个线程正在做某个具体业务时，中间不可以被加塞或者被分割。需要整体完整
 *          要么同时成功，要么同时失败
 *      2.2 是否可以保证原子性案例演示
 *      2.3 why
 *      2.4 如何解决原子性
 *          * 加sync
 *          * 使用我们的juc下面的AtomicInteger
 */
public class VolatileDemo {
    public static void main(String[] args) {
        nonAtomic();
    }

    /**
     * 2、不保证原子性以及如何解决
     */
    private static void nonAtomic() {
        MyData myData = new MyData();
        for (int i = 1; i <= 20 ; i++) {
            new Thread(()->{
                for (int j = 1; j <= 1000 ; j++) {
                   myData.addPlusPlus();
                   myData.addMyAtomic();
                }
            },String.valueOf(i)).start();
        }
        while (Thread.activeCount()>2){
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName()+"\t finally number value:"+myData.number);
        System.out.println(Thread.currentThread().getName()+"\t finally MyAtomic value:"+myData.atomicInteger);
    }

    /**
     * 1 验证volatile可见性
     */
    private static void volatileVisible() {
        MyData myData = new MyData();
        new Thread(()->{
            System.out.println(Thread.currentThread().getName()+"\t come in");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            myData.addT060();
            System.out.println(Thread.currentThread().getName()+"\t update number value:"+myData.number);
        },"AAA").start();
        //第二个线程是main线程
        while (myData.number==0){

        }
        System.out.println(Thread.currentThread().getName()+"\t mission is over");
    }
}
