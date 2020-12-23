package com.lss.gc;
/*
-verbose:gc -Xmx200M -Xmn50M -XX:TargetSurvivorRatio=60 -XX:+PrintTenuringDistribution -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:MaxTenuringThreshold=3
 */
public class MyTest4 {
    public static void main(String[] args) throws InterruptedException {
        byte[] alloc1=new byte[512*1024];
        byte[] alloc2=new byte[512*1024];
        myGc();
        Thread.sleep(1000);
        System.out.println(11111);
        myGc();
        Thread.sleep(1000);
        System.out.println(2222);
        myGc();
        Thread.sleep(1000);
        System.out.println(3333);
        myGc();
        Thread.sleep(1000);
        System.out.println(4444);
        byte[] alloc3=new byte[1024*1024];
        byte[] alloc4=new byte[1024*1024];
        byte[] alloc5=new byte[1024*1024];
        myGc();
        Thread.sleep(1000);
        System.out.println(5555);
        myGc();
        Thread.sleep(1000);
        System.out.println(666);
        System.out.println("hello world");
    }

    private static void myGc() {
        for (int i = 0;i<40;i++){
            byte[] alloc=new byte[1024*1024];
        }
    }
}
