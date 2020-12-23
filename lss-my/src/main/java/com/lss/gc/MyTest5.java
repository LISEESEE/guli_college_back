package com.lss.gc;

/**
 * CMS例子
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:+UseConcMarkSweepGC
 * 老年代的CMS和新生代的ParNew是成对出现的
 */
public class MyTest5 {
    public static void main(String[] args) {
        int size = 1024*1024;
        byte[] alloc1=new byte[4*size];
        System.out.println("111111");
        byte[] alloc2=new byte[4*size];
        System.out.println("22222222");
        byte[] alloc4=new byte[4*size];
        System.out.println("33333333");
        byte[] alloc3=new byte[2*size];

        System.out.println("444444444");
    }
}
