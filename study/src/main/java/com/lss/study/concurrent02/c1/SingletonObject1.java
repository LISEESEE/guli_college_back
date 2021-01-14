package com.lss.study.concurrent02.c1;

public class SingletonObject1 {

    /**
     * 不能懒加载
     */
    private static final SingletonObject1 instance = new SingletonObject1();

    private SingletonObject1() {
        //empty
    }

    public static SingletonObject1 getInstance() {
        return instance;
    }
}