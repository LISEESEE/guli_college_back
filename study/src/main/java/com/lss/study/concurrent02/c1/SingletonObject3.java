package com.lss.study.concurrent02.c1;

public class SingletonObject3 {
    //多线程下效率低，读写都阻塞
    private static SingletonObject3 instance;

    private SingletonObject3() {
        //empty
    }

    public synchronized static SingletonObject3 getInstance() {

        if (null == instance)
            instance = new SingletonObject3();

        return SingletonObject3.instance;
    }
}