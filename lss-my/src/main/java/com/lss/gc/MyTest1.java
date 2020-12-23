package com.lss.gc;

/**
 * -verbose:gc GC详细信息
 * -Xms20M ：堆最小20m
 * -Xmx20M：堆最大20m
 * -Xmn10M：新生代的大小
 * -XX:+PrintGCDetails gc详细信息
 * -XX:SurvivorRatio=8 eadin和survivor占比8：1
 *
 * PSYoungGen:Parallel Scavenge（新生代垃圾收集器）
 * ParOldGen：Parallel Old（老年代垃圾收集器）
 */
public class MyTest1 {
    public static void main(String[] args) {
        int size = 1024*1024;
        byte[] alloc1=new byte[2*size];
        byte[] alloc2=new byte[2*size];
        byte[] alloc3=new byte[3*size];

        System.out.println("hello world");
        /*
        [GC (Allocation Failure) [PSYoungGen: 6099K->792K(9216K)] 6099K->4896K(19456K), 0.0025048 secs] [Times: user=0.08 sys=0.02, real=0.00 secs]
        hello world
        Heap
         PSYoungGen      total 9216K, used 4101K [0x00000000ff600000, 0x0000000100000000, 0x0000000100000000)
          eden space 8192K, 40% used [0x00000000ff600000,0x00000000ff93b4f8,0x00000000ffe00000)
          from space 1024K, 77% used [0x00000000ffe00000,0x00000000ffec6030,0x00000000fff00000)
          to   space 1024K, 0% used [0x00000000fff00000,0x00000000fff00000,0x0000000100000000)
         ParOldGen       total 10240K, used 4104K [0x00000000fec00000, 0x00000000ff600000, 0x00000000ff600000)
          object space 10240K, 40% used [0x00000000fec00000,0x00000000ff002020,0x00000000ff600000)
         Metaspace       used 3226K, capacity 4496K, committed 4864K, reserved 1056768K
          class space    used 350K, capacity 388K, committed 512K, reserved 1048576K
         */
    }
}
