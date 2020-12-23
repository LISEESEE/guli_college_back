package oom;

import java.nio.ByteBuffer;

public class DirectBufferMemoryDemo {
    //-Xms10m -Xmx10m -XX:+PrintGCDetails -XX:MaxDirectMemorySize=5m
    //Exception in thread "main" java.lang.OutOfMemoryError: Direct buffer memory
    public static void main(String[] args) throws InterruptedException {
        System.out.println("配置的maxDirectMemory："+(sun.misc.VM.maxDirectMemory()/(double)1024/1024)+"MB");

        Thread.sleep(3000);

        ByteBuffer bb = ByteBuffer.allocateDirect(6*1024*1024);
    }
}
