package com.lss.study.concurrent02.c1;

//通过holder方式
public class SingletonObject6 {
    public SingletonObject6() {
    }
    private static class InstanceHolder{
        private final static SingletonObject6 instance = new SingletonObject6();
    }
    public static SingletonObject6 getInstance(){
        return InstanceHolder.instance;
    }
}
