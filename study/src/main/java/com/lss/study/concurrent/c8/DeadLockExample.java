package com.lss.study.concurrent.c8;

import java.util.concurrent.TimeUnit;

/**
 查看方式：jps
 jstack 端口
 */
public class DeadLockExample {
    public static void main(String[] args) {
        deadLock();
    }

    private static void deadLock() {
        final Object OBJ1 = new Object();
        final Object OBJ2 = new Object();
        new Thread(() -> {
            synchronized (OBJ1) {
                System.out.println("获取obj1成功");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (OBJ2) {
                    System.out.println("获取obj2成功");
                }
            }
        }).start();

        new Thread(() -> {
            synchronized (OBJ2) {
                System.out.println("获取obj2成功");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (OBJ1) {
                    System.out.println("获取obj1成功");
                }
            }
        }).start();
    }

}
