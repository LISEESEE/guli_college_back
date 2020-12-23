package com.lss.study.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TestStreamAPI {
    List<Employee> employees = Arrays.asList(
            new Employee("张三", 18, 9999.99),
            new Employee("李四", 38, 5555.99),
            new Employee("王五", 50, 6666.66),
            new Employee("赵六", 16, 9999.99),
            new Employee("田七", 8, 1.11)
    );

    @Test
    public void test1() {
        Integer[] nums = new Integer[]{1, 2, 3, 4, 5};
        Arrays.stream(nums).map((x) -> x * x).forEach(System.out::println);
    }

    @Test
    public void test2() {
        Optional<Integer> count = employees.stream().map((e) -> 1).reduce(Integer::sum);
        System.out.println(count);
    }
}