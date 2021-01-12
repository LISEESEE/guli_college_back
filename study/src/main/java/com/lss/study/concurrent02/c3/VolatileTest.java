package com.lss.study.concurrent02.c3;

//volatile测试类
public class VolatileTest {

    private static volatile int INIT_VALUE = 0;

    private final static int MAX_LIMIT = 500;

    public static void main(String[] args) {
        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (localValue < MAX_LIMIT) {
                if (localValue != INIT_VALUE) {
                    System.out.printf("The value updated to [%d]\n", INIT_VALUE);
                    localValue = INIT_VALUE;
                }
            }
        }, "READER").start();

        new Thread(() -> {
            int localValue = INIT_VALUE;
            while (INIT_VALUE < MAX_LIMIT) {
                System.out.printf("Update the value to [%d]\n", ++localValue);
                INIT_VALUE = localValue;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "UPDATER").start();
    }
    /**
      缓存不一致解决方案：
      1、给数据总线加锁
           总线（数据总线，地址总线，控制总线）
           LOCK#
      2、CPU高速缓存一致性协议
           Intel MESI
      核心思想
      1、当CPU写入数据的时候，如果发现该变量被共享（也就是说，在其他CPU中也存在该变量的副本），
      会发出一个信号，通知其他CPU该变量的缓存无效
      2、当其他CPU访问该变量的时候，重新到主内存进行获取
     */
}