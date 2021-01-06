package com.lss.study.concurrent.c2;

public class TicketWindowV2 implements Runnable {

    private final static Integer MAX = 50;

    private Integer index = 1;

    @Override
    public void run() {
        while (index <= MAX) {
            System.out.println(Thread.currentThread() + " 的号码为：" + index++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
