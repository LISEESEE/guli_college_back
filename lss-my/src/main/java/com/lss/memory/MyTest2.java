package com.lss.memory;
/*
    虚拟机栈溢出
    -Xss6000k
    java.lang.StackOverflowError
 */
public class MyTest2 {
    private int length;

    public int getLength() {
        return length;

    }

    public void test() {
        this.length++;
        test();
    }

    public static void main(String[] args) {
        MyTest2 myTest2 = new MyTest2();
        try{
            myTest2.test();
        } catch (Throwable ex){
            System.out.println(myTest2.length);
            ex.printStackTrace();
        }
    }

}
