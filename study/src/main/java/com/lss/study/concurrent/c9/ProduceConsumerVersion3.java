package com.lss.study.concurrent.c9;

import java.util.stream.Stream;

//生产者消费者3 多线程完整版
public class ProduceConsumerVersion3 {
    private int i = 0;

    private final Object LOCK = new Object();

    private volatile boolean isProduce = false;

    public void produce() {
        synchronized (LOCK) {
            while (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            i++;
            System.out.println("P->" + i);
            LOCK.notifyAll();
            isProduce = true;

        }
    }

    public void consume() {
        synchronized (LOCK) {
            while (!isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("C->" + i);
            LOCK.notify();
            isProduce = false;

        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion3 pc = new ProduceConsumerVersion3();
        Stream.of("P1", "P2").forEach(
                n -> new Thread(n) {
                    @Override
                    public void run() {
                        while (true) {
                            pc.produce();
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );
        Stream.of("C1", "C2").forEach(
                n -> new Thread(n) {
                    @Override
                    public void run() {
                        while (true){
                            pc.consume();
                            try {
                                Thread.sleep(1);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }.start()
        );
    }
}
