package com.lss.study.concurrent02.c10;

import java.util.HashMap;
import java.util.Map;

public class ThreadLocalSimulator<T> {
    private final Map<Thread,T> storage = new HashMap<>();
    public void set(T t){
        synchronized (this){
            storage.put(Thread.currentThread(),t);
        }
    }
    public T get(){
        synchronized (this){
            T value = storage.get(Thread.currentThread());
            if (value == null){
                return initialValue();
            }
            return value;
        }
    }
    public T initialValue() {
        return null;
    }
}
