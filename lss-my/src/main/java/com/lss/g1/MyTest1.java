package com.lss.g1;

/**
 * jvm参数：-verbose:gc -Xms10m -Xmx10m -XX:+UseG1GC -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:MaxGCPauseMillis=200m
 */
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024*1024;
        byte[] alloc1=new byte[size];
        byte[] alloc2=new byte[size];
        byte[] alloc3=new byte[size];

        System.out.println("hello world");
    }
}
