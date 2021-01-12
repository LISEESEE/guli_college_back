package com.lss.study.concurrent02.c3;

/**
 并发编程中三个比较重要的概念
 1、原子性A
    一个操作或者多个操作，要么都成功，要么都失败，中间不能有任何的任何因素中断
 2、可见性
 3、有序性 重排序只要求最终一致性
    代码的执行顺序，编写在前面的发生在编写后面的
    unlock必须发生在lock之后
    volatile修饰的变量，对一个变量的写操作先于对该变量的读操作
    传递规则，操作A先于B，B先于C，那么A肯定先于C
    线程启动规则，start方法肯定先于线程run
    线程中断规则，interrupt这个动作，必须发生在捕获该动作之前
    对象销毁规则，初始化必须发生在finalize之前
    线程中介规则，所有的操作都发生在线程死亡之前
 */
//不保证原子性
public class VolatileTest2 {

    private static volatile int INIT_VALUE = 0;

    private final static int MAX_LIMIT = 500;

    public static void main(String[] args) {
        new Thread(() -> {
            while (INIT_VALUE < MAX_LIMIT) {
                int localValue = INIT_VALUE;
                localValue++;
                INIT_VALUE = localValue;
                System.out.println("T1->" + localValue);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ADDER-1").start();

        new Thread(() -> {
            while (INIT_VALUE < MAX_LIMIT) {
                int localValue = INIT_VALUE;
                localValue++;
                INIT_VALUE = localValue;
                System.out.println("T2->" + localValue);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "ADDER-1").start();
    }
}
