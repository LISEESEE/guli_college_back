package com.lss.study.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TestLambda {
    //原来的匿名内部类
    @Test
    public void test1(){
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1,o2);
            }
        };
        TreeSet<Integer> ts = new TreeSet<>(com);
    }
    @Test
    public void test2(){
        Comparator<Integer> com = (x,y)->Integer.compare(x,y);
        TreeSet<Integer> ts = new TreeSet<>(com);
    }
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,6666.66),
            new Employee("赵六",16,9999.99),
            new Employee("田七",8,1.11)
    );
    //stream api
    @Test
    public void test3(){
        employees.stream().filter((e)->e.getSalary()>=5000)
                .limit(2).forEach(System.out::println);
        employees.stream().map(Employee::getName).forEach(System.out::println);
    }
}
