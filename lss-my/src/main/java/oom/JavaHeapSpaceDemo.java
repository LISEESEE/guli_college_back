package oom;

import java.util.Random;

public class JavaHeapSpaceDemo {
    public static void main(String[] args) {
        //-Xms10m -Xmx10m
        //Exception in thread "main" java.lang.OutOfMemoryError: Java heap space
        String str = "atguigu";
        while (true){
            str+=str+new Random().nextInt(11111111)+new Random().nextInt(22222222);
            str.intern();
        }
    }
}
