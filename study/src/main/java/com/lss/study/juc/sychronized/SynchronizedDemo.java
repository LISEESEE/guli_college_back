package com.lss.study.juc.sychronized;

public class SynchronizedDemo {
    Object object=new Object();

    public void synchronizedMethod(){
        new Thread(()->{
            synchronized (object){
                System.out.println(Thread.currentThread().getName()+"\t"+"外层....");
                synchronized (object){
                    System.out.println(Thread.currentThread().getName()+"\t"+"中层....");
                    synchronized (object){
                        System.out.println(Thread.currentThread().getName()+"\t"+"内层....");
                    }
                }
            }
        },"A").start();
    }
    public static void main(String[] args) {
        new SynchronizedDemo().synchronizedMethod();
        /*
        输出结果：
            A	外层....
            A	中层....
            A	内层....
        * */
    }
}
