package com.lss.study.concurrent01.c11;

import java.util.Arrays;
import java.util.Optional;

public class Test2 {

    public void test() {
        Arrays.asList(Thread.currentThread().getStackTrace()).stream()
                .filter(e->!e.isNativeMethod())
                .forEach(e-> Optional.of(e.getClassName()+":"+e.getMethodName()+":"+e.getLineNumber())
                .ifPresent(System.out::println));
    }
}