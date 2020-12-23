package com.lss.gc;

/**
 * java -XX:+PrintCommandLineFlags -version
 *      ->-XX:InitialHeapSize=199689856 -XX:MaxHeapSize=3195037696 -XX:+PrintCommandLineFlags -XX:+UseCompressedClassPointers -XX:+UseCompressedOops -XX:-UseLargePagesIndividualAllocation -XX:+UseParallelGC
 *          java version "1.8.0_211"
 *          Java(TM) SE Runtime Environment (build 1.8.0_211-b12)
 *          Java HotSpot(TM) 64-Bit Server VM (build 25.211-b12, mixed mode)
 *-XX:PretenureSizeThreshold=4194304
 *
 *  创建的对象大小超过阈值，直接在老年代上创建，不在新生代上创建
 *  PretenureSizeThreshold必须要搭配串行的垃圾收集器：-XX:+UseSerialGC
 *
 *  System.gc();可以让程序在不创建对象的时候执行垃圾回收
 */
public class MyTest2 {
    public static void main(String[] args) throws InterruptedException {
        int size = 1024*1024;
        byte[] s = new byte[5*size];
        Thread.sleep(1000000);
    }
}
