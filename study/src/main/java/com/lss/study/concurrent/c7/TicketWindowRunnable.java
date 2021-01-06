package com.lss.study.concurrent.c7;

public class TicketWindowRunnable implements Runnable {

    private final static Integer MAX = 500;

    private Integer index = 1;

    private final Object MONITOR = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (MONITOR) {
                if (index > MAX)
                    break;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread() + " 的号码为：" + index++);
            }

        }
    }
}