package com.lss.study.concurrent01.c2;


public class TicketWindow extends Thread {
    private String name;

    private final static Integer MAX = 50;

    private  Integer i = 1;

    public TicketWindow(String name ) {
        this.name = name;
    }

    @Override
    public void run() {
        while (i <= MAX) {
            System.out.println(name+"号码为："+i++);
        }
    }
}
