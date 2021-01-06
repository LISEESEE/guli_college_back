package com.lss.study.concurrent.c2;

public class TaxCalculatorMain {
    public static void main(String[] args) {
        TaxCalculator taxCalculator = new TaxCalculator(10000d,2000d,(a,b)->a*0.1+b*0.15);
//        TaxCalculator taxCalculator = new TaxCalculator(10000d, 2000d);
//        CalculatorStrategy strategy = new CalculatorStrategyImpl();
//        taxCalculator.setCalculatorStrategy(strategy);
        System.out.println(taxCalculator.calculate());
    }
}
