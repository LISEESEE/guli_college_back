package com.lss.study.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

public class TestStreamAPI2 {
    List<Employee> employees = Arrays.asList(
            new Employee("张三",18,9999.99),
            new Employee("李四",38,5555.99),
            new Employee("王五",50,6666.66),
            new Employee("赵六",16,9999.99),
            new Employee("田七",8,11111.11),
            new Employee("田七",8,11111.11),
            new Employee("田七",8,11111.11)
    );
    //中间操作
    /**
     筛选与切片
     filter——接收lambda，从流中排除某些元素
     limit——截断流，使其元素不超过给定数量
     skip(n)——跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
     distinct——筛选，通过流所生成元素的hashCode()和equals()去除重复元素
     */
    @Test
    public void test1(){
        //中间操作：不会执行任何操作
        Stream<Employee> stream = employees.stream()
                .filter((e)->{
                    System.out.println("Stream API的中间操作");
                    return e.getAge()>35;
                });
        //终止操作：一次性执行全部内容，即惰性求值
        stream.forEach(System.out::println);
    }
    //外部迭代
    @Test
    public void test2(){
        Iterator<Employee> it = employees.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
    @Test
    public void test3(){
      employees.stream().filter((e)->e.getSalary()>5000).limit(2)
              .forEach(System.out::println);
    }
    @Test
    public void test4(){
        employees.stream().filter((e)->e.getSalary()>5000).skip(2)
                .forEach(System.out::println);
    }
    @Test
    public void test5(){
        employees.stream().filter((e)->e.getSalary()>5000).skip(2).distinct()
                .forEach(System.out::println);
    }
    /**
     映射
     map——接收lambda，将元素转换成其他形式或提取信息。接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
     flatMap——接收一个函数作为参数，将流中的每一个值都换成另一个流，然后把所有流连接成一个流
     */
    @Test
    public void test6(){
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "ddd");
        list.stream()
                .map((str)->str.toLowerCase())
                .forEach(System.out::println);

        System.out.println("------------------");

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);

        System.out.println("------------------");

        Stream<Stream<Character>> streamStream = list.stream()
                .map(TestStreamAPI2::filterCharacter);
        streamStream.forEach((sm)->{
            sm.forEach(System.out::println);
        });

        System.out.println("------------------");

        Stream<Character> stream = list.stream()
                .flatMap(TestStreamAPI2::filterCharacter);


    }
    public static Stream<Character> filterCharacter(String str){
        List<Character> list = new ArrayList<>();
        for (Character ch:str.toCharArray()) {
            list.add(ch);
        }
        return list.stream();
    }

    /**
     * 排序
     * sorted()——自然排序(Comparable)
     * sorted(Comparator com)——定制排序(Comparator)
     */
    @Test
    public void test7(){
        List<String> list = Arrays.asList("ccc", "ddd","aaa", "bbb" );
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("------------------");
        employees.stream()
                .sorted((e1,e2)->{
                    if (e1.getAge()==e2.getAge()){
                        return e1.getName().compareTo(e2.getName());
                    }else{
                        return e1.getAge().compareTo(e2.getAge());
                    }
                }).forEach(System.out::println);
    }
}
