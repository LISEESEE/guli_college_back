package com.lss.study.concurrent.c2;

public class CalculatorStrategyImpl implements CalculatorStrategy {
    private final static double SALARY_RATE = 0.1;
    private final static double BONUS_RATE = 0.15;
    @Override
    public double calculator(double salary, double bonus) {
        return salary*SALARY_RATE+BONUS_RATE*bonus;
    }
}
