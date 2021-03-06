package com.lss.study.concurrent01.c3;

public class CreateThread5 {

    private static int counter = 1;

    public static void main(String[] args) {

        try {
            for (int i = 0; i < 1000; i++) {
                counter++;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            add(1);
                        } catch (Error e) {
//                            System.out.println(counter);
                        }
                    }

                    private void add(int i) {

                        add(i + 1);
                    }
                }).start();
            }
        } catch (Error e) {
            counter++;
        }
        System.out.println("Total created thread nums=>" + counter);
    }
}
