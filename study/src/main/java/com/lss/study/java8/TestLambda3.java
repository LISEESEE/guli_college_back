package com.lss.study.java8;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 java8内置的四大核心函数式接口
 Consumer<T>：消费型接口
    void accept(T t);
 Supplier<T>：共给型接口
    T get();
 Function<T,R>：函数型接口
    R apply(T t);

 */
public class TestLambda3 {
    //Consumer<T>消费型接口
    @Test
    public void test1(){
        happy(1000,(m)->System.out.print("我喜欢大宝剑，每次消费"+m+"元"));
    }

    private void happy(int i, Consumer<Integer> con) {
        con.accept(i);
    }
    //Supplier<T>供给型接口
    @Test
    public void test2(){
        List<Integer> numList = getNumList(10, () -> (int)( Math.random() * 100));
        for (Integer num : numList) {
            System.out.println(num);
        }
    }
    public List<Integer> getNumList(int num, Supplier<Integer> sup){
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Integer n = sup.get();
            list.add(n);
        }
        return list;
    }
    //Function<T,R>函数型接口
    @Test
    public void test3(){
        String newStr = strHandler("\t\t\t 我呀买房", (str) -> str.trim());
        System.out.println(newStr);
    }
    public String strHandler(String str, Function<String,String> fun){
        return fun.apply(str);
    }
    //Predicate<T>断言型接口
    @Test
    public void test4(){
        List<String> list = Arrays.asList("hello","atguigu","lambda","www","ok");
        List<String> strList = filterStr(list,(s) -> s.length()>3);
        for (String str: strList
             ) {
            System.out.println(str);
        }
    }
    public List<String> filterStr(List<String> list, Predicate<String> pre){
        List<String> stringList = new ArrayList<>();
        for (String str: list ) {
            if(pre.test(str)){
                stringList.add(str);
            }
        }
        return stringList;
    }
}
