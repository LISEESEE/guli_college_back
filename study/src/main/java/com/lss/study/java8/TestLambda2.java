package com.lss.study.java8;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
  一、lambda表达式的基础语法:java8中引入了一个新的操作符"->"该操作符称为箭头操作符或lambda操作符
    箭头操作符将lambda表达式拆分成两部分：
    左侧：lambda表达式的参数列表
    右侧：lambda表达式中所需执行的功能，即lambda体
    语法格式一：无参数，无返回值
        ()->System.out.println("hello lambda!");
    语法格式二：一个参数，有返回值
        (x)-> System.out.println(x)
    语法格式三：若只有一个参数，小括号可以省略不写
        x-> System.out.println(x)
    语法格式四：有两个以上的参数，有返回值，并且lambda体中有多条语句
     Comparator<Integer> comparator = (x,y)->{
         System.out.println("函数式接口");
         return Integer.compare(x,y);
     };
    语法格式五：若lambda体中只有一条语句，return和大括号都可以省略不写
        Comparator<Integer> com = (x,y) ->Integer.compare(x,y);
    语法格式六：lambda表达式的参数列表的数据类型可以省略不写，因为JVM编译器可以通过上下文推断出数据类型即类型推断
        (Integer x,Integer y) ->Integer.compare(x,y);
     左右遇一括号省
     左侧推断类型省
 */
public class TestLambda2 {
    @Test
    public void test1(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello world");
            }
        };
        r.run();
        System.out.println("-----------------------");
        Runnable r1 = ()-> System.out.println("hello lambda");
        r1.run();
    }
    @Test
    public void test2(){
        Consumer<String> consumer = (x)-> System.out.println(x);
        consumer.accept("中国知网！");
    }
    @Test
    public void test3(){
        Comparator<Integer> comparator = (x,y)->{
            System.out.println("函数式接口");
            return Integer.compare(x,y);
        };
    }
    @Test
    public void test4(){
        Comparator<Integer> com = (x,y) ->Integer.compare(x,y);
    }
}
