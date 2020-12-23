package com.lss.memory;

/**
 * 死锁
 */
public class MyTest3 {
    public static void main(String[] args) {
        new Thread(A::method,"Thread-A").start();
        new Thread(B::method,"Thread-B").start();

    }
}
class A{
    public static synchronized void method() {
        System.out.println("method from A");
        try{
            Thread.sleep(5000);
            B.method();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class B{
    public static synchronized void method() {
        System.out.println("method from B");
        try{
            Thread.sleep(5000);
            A.method();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}