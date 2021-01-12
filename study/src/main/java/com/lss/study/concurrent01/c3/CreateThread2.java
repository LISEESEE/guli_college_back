package com.lss.study.concurrent01.c3;

import java.util.Arrays;

//
public class CreateThread2 {
    public static void main(String[] args) {
        Thread t = new Thread() {
            public void run() {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        System.out.println("==================");
        System.out.println(t.getThreadGroup());//java.lang.ThreadGroup[name=main,maxpri=10]
        System.out.println(Thread.currentThread().getName());//main
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        System.out.println(threadGroup.getName());//main
        System.out.println("==================");
        System.out.println(threadGroup.activeCount());//3

        Thread[] threads = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(threads);

        Arrays.asList(threads).forEach(System.out::println);
        //Thread[main,5,main]
        //Thread[Monitor Ctrl-Break,5,main]
        //Thread[Thread-0,5,]
    }
}
