package com.lss.study.java8;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class TestStreamAPI3 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99, Employee.Status.FREE),
            new Employee("李四",38,5555.99, Employee.Status.BUSY),
            new Employee("王五",50,6666.66, Employee.Status.VOCATION),
            new Employee("赵六",16,9999.99, Employee.Status.FREE),
            new Employee("田七",8,1.11, Employee.Status.BUSY)
    );
    /**
     查找与匹配
     allMatch——检查是否匹配所有元素
     anyMatch——检查是否至少匹配一个元素
     noneMatch——检查是没有匹配所有元素
     findFirst——返回第一个元素
     findAny——返回当前流中的任意元素
     count——返回流中元素的总个数
     max——返回流中最大值
     min——返回流中最小值

     */
    @Test
    public void test1() {
        boolean b1 = employees.stream()
                .allMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b1);
        boolean b2 = employees.stream()
                .anyMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b2);
        boolean b3 = employees.stream()
                .noneMatch((e) -> e.getStatus().equals(Employee.Status.BUSY));
        System.out.println(b3);
        Optional<Employee> op = employees.stream()
                .sorted((e1, e2) -> -Double.compare(e1.getSalary(), e2.getSalary()))
                .findFirst();
        System.out.println(op.get());
        Optional<Employee> op2 = employees.stream()
                .filter((e1)->e1.getStatus().equals(Employee.Status.BUSY))
                .findAny();
        System.out.println(op2.get());
    }
    @Test
    public void test2(){
        long count = employees.stream()
                .count();
        System.out.println(count);
        Optional<Employee> op1 = employees.stream()
                .max((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(op1);

        Optional<Double> op2 = employees.stream()
                .map(Employee::getSalary)
                .min(Double::compare);
        System.out.println(op2);
    }
    /**
     规约
     reduce(T identity,BinaryOperator)/reduce(BinaryOperator)——可以将流中元素反复结合起来，得到一个值
     */
    @Test
    public void test3(){
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer sum = list.stream()
                .reduce(0, Integer::sum);
        System.out.println(sum);
        Optional<Double> op = employees.stream()
                .map(Employee::getSalary)
                .reduce(Double::sum);
        System.out.println(op.get());
    }
    /**
     收集
     collect——将流转换为其他形式。接收一个Collector接口的实现，用于给Stream中元素做汇总的方法
     */
    @Test
    public void test4(){
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("---------------");
        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);

        System.out.println("---------------");
        HashSet<String> hashSet = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hashSet.forEach(System.out::println);
    }
    @Test
    public void test5(){
        //总数
        Long collect = employees.stream()
                .collect(Collectors.counting());
        System.out.println(collect);
        System.out.println("---------------");
        //平均值
        Double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(avg);
        //总和
        Double sum = employees.stream()
                .collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(sum);
        //最大值
        Optional<Employee> max = employees.stream()
                .collect(Collectors.maxBy((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary())));
        System.out.println(max.get());
        //最小值
        Optional<Double> min = employees.stream()
                .map(Employee::getSalary)
                .collect(Collectors.minBy(Double::compare));
        System.out.println(min);
    }
    //分组
    @Test
    public void test6(){
        Map<Employee.Status, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        map.forEach((k,v)-> System.out.println(k+":"+v));
    }
    //多级分组
    @Test
    public void test7(){
        Map<Employee.Status, Map<String, List<Employee>>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy((e) -> {
                    if (e.getAge() <= 35) {
                        return "青年";
                    } else if (e.getAge() <= 50) {
                        return "中年";
                    } else {
                        return "老年";
                    }
                })));
        map.forEach((k,v)-> System.out.println(k+":"+v));
    }
    //分区
    @Test
    public void test8(){
        Map<Boolean, List<Employee>> collect = employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.getSalary() > 8000));
        System.out.println(collect);
    }
    @Test
    public void test9(){
        DoubleSummaryStatistics dss = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getSum());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMax());
    }
    @Test
    public void test10(){
        String str = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(",","[","]"));
        System.out.println(str);
    }
}
