package com.lss.study.java8;

public interface MyFun {
    /**

     Java8允许接口中有默认方法和静态方法
     */
    default String getName(){
        return "哈哈哈";
    }
    public static void show(){
        System.out.println("接口中的静态方法");
    }
}
