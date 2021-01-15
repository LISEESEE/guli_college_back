package com.lss.study.concurrent02.c9;

import java.util.Random;

public class ServerThread extends Thread {

    private final RequestQueue queue;

    private final Random random;

    private volatile boolean closed = false;

    public ServerThread(RequestQueue queue) {
        this.queue = queue;
        random = new Random(System.currentTimeMillis());
    }

    @Override
    public void run() {
        while (!closed) {
            Request request = queue.getRequest();
            if (null == request) {
                System.out.println("Received the empty request.");
                continue;
            }
            System.out.println("Server ->" + request.getValue());
            try {
                Thread.sleep(random.nextInt(1000));
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    public void close() {
        this.closed = true;
        this.interrupt();
    }
}