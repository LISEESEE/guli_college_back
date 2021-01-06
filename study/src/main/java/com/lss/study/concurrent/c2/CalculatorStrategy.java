package com.lss.study.concurrent.c2;

@FunctionalInterface
public interface CalculatorStrategy {
    double calculator(double salary,double bonus);
}
