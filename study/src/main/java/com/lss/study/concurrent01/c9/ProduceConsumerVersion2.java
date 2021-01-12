package com.lss.study.concurrent01.c9;

import java.util.stream.Stream;

//生产者消费者2（多线程下有问题）假死：都放弃了CP执行权 wait了
public class ProduceConsumerVersion2 {
    private int i = 0;

    private final Object LOCK = new Object();

    private volatile boolean isProduce = false;

    public void produce() {
        synchronized (LOCK){
            if (isProduce){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else{
                i++;
                System.out.println("P->"+i);
                LOCK.notify();
                isProduce = true;
            }
        }
    }
    public void consume(){
        synchronized (LOCK){
            if (isProduce){
                System.out.println("C->"+i);
                LOCK.notify();
                isProduce = false;
            }else{
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion2 pc = new ProduceConsumerVersion2();
        Stream.of("P1","P2").forEach(
                n-> new Thread(n){
                    @Override
                    public void run() {
                        while (true)
                            pc.produce();
                    }
                }.start()
        );
        Stream.of("C1","C2").forEach(
                n-> new Thread(n){
                    @Override
                    public void run() {
                        while (true)
                            pc.consume();
                    }
                }.start()
        );
    }
}
