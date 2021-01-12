package com.lss.study.concurrent02.c1;

public class SingletonObject2 {
    //多线程下安全问题
    private static SingletonObject2 instance;

    private SingletonObject2() {
        //empty
    }

    public static SingletonObject2 getInstance() {
        if (null == instance)
            instance = new SingletonObject2();

        return SingletonObject2.instance;
    }
}
