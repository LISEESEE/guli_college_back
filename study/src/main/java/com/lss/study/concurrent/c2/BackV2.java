package com.lss.study.concurrent.c2;

public class BackV2 {
    public static void main(String[] args) {
        final TicketWindowV2 windowV2 = new TicketWindowV2();

        Thread t1 = new Thread(windowV2,"窗口1");
        Thread t2 = new Thread(windowV2,"窗口2");
        Thread t3 = new Thread(windowV2,"窗口3");
        t1.start();
        t2.start();
        t3.start();
    }
}
