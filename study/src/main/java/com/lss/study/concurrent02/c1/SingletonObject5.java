package com.lss.study.concurrent02.c1;

public class SingletonObject5 {

    private static volatile SingletonObject5 instance;

    private SingletonObject5() {
        //---
    }

    //double check 性能提高  可能会重排序 产生空指针
    public static SingletonObject5 getInstance() {

        if (null == instance) {
            synchronized (SingletonObject5.class) {
                if (null == instance)
                    instance = new SingletonObject5();
            }
        }

        return SingletonObject5.instance;
    }
}