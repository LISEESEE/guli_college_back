package com.lss.study.concurrent02.c8;

public interface Future<T> {

    T get() throws InterruptedException;

}