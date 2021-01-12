package com.lss.study.concurrent01.c2;

public class Back {
    public static void main(String[] args) {
        TicketWindow t1 = new TicketWindow("窗口1");
        t1.start();

        TicketWindow t2 = new TicketWindow("窗口2");
        t2.start();
        TicketWindow t3 = new TicketWindow("窗口3");
        t3.start();
    }
}
