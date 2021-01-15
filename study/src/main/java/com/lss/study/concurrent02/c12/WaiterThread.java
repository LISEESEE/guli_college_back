package com.lss.study.concurrent02.c12;

import java.io.IOException;

public class WaiterThread extends Thread {
    private final BalkingData balkingData;

    public WaiterThread(BalkingData balkingData) {
        super("waiter");
        this.balkingData = balkingData;
    }

    @Override
    public void run() {
        for (int i = 0; i < 200; i++) {
            try {
                balkingData.save();
                Thread.sleep(1_000L);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
