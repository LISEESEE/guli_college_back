package com.lss.study.concurrent02.c1;

public class SingletonObject4 {

    private static SingletonObject4 instance;

    private SingletonObject4() {
        //---
    }

    //double check 性能提高  可能会重排序 产生空指针
    public static SingletonObject4 getInstance() {

        if (null == instance) {
            synchronized (SingletonObject4.class) {
                if (null == instance)
                    instance = new SingletonObject4();
            }
        }

        return SingletonObject4.instance;
    }
}