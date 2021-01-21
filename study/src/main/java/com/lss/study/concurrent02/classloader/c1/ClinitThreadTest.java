package com.lss.study.concurrent02.classloader.c1;

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 多线程下类的static只会被一个线程抢到  是线程安全的
 */
public class ClinitThreadTest {

    public static void main(String[] args) {

        System.out.println(System.getProperty("sun.boot.class.path"));

        new Thread(SimpleObject::new).start();

        new Thread(SimpleObject::new).start();
    }

    static class SimpleObject {

        private static AtomicBoolean init = new AtomicBoolean(true);

        static {
            System.out.println(Thread.currentThread().getName() + " I will be initial");
            while (init.get()) {

            }
            System.out.println(Thread.currentThread().getName() + " I am finished initial.");
        }
    }
}
