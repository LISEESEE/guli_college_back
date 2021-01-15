package com.lss.study.concurrent02.c10;

public class ThreadLocalSimpleTest {
    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue(){
            return "bilibili";
        }
    };


    public static void main(String[] args) throws InterruptedException {
        Thread.sleep(10);
        System.out.println(threadLocal.get());
    }
}
