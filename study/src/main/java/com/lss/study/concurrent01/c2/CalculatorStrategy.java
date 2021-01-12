package com.lss.study.concurrent01.c2;

@FunctionalInterface
public interface CalculatorStrategy {
    double calculator(double salary,double bonus);
}
