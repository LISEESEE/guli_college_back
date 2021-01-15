package com.lss.study.concurrent02.c11;

import java.util.stream.IntStream;

public class ContextTest {
    public static void main(String[] args) {
        IntStream.range(1,5)
                .forEach(i-> new Thread(new ExecutionTask()).start());
    }
}
