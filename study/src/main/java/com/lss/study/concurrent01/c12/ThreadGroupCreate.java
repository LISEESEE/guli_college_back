package com.lss.study.concurrent01.c12;

import java.util.Arrays;

public class ThreadGroupCreate {

    public static void main(String[] args) {
        //use the name

        ThreadGroup tg1 = new ThreadGroup("TG1");
        Thread t1 = new Thread(tg1, "t1") {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println(getThreadGroup().getName());//TG1
                        System.out.println(getThreadGroup().getParent());//java.lang.ThreadGroup[name=main,maxpri=10]
                        System.out.println(getThreadGroup().getParent().activeCount());//3
                        Thread.sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

        t1.start();

        System.out.println("===============");
        ThreadGroup tg2 = new ThreadGroup("TG2");
        Thread t2 = new Thread(tg2, "T2") {
            @Override
            public void run() {
                System.out.println(">>>"+tg1.getName());//>>>TG1
                Thread[] threads = new Thread[tg1.activeCount()];
                tg1.enumerate(threads);
                System.out.println("+++");
                Arrays.asList(threads).forEach(System.out::println);//Thread[t1,5,TG1]
            }
        };

        t2.start();

        System.out.println(tg2.getName());//TG2
        System.out.println(tg2.getParent());//java.lang.ThreadGroup[name=main,maxpri=10]


        System.out.println(Thread.currentThread().getName());//main
        System.out.println(Thread.currentThread().getThreadGroup().getName());//main
    }
}