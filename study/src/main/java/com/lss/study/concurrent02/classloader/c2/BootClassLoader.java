package com.lss.study.concurrent02.classloader.c2;

public class BootClassLoader {

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));

        Class<?> klass = Class.forName("com.lss.study.concurrent02.classloader.c2.SimpleObject");
        System.out.println(klass.getClassLoader());//应用类加载器
        System.out.println(klass.getClassLoader().getParent());//扩展类加载器
        System.out.println(klass.getClassLoader().getParent().getParent());//根类加载器


        Class<?> clazz = Class.forName("java.lang.String");
        System.out.println(clazz);//class java.lang.String
        System.out.println(clazz.getClassLoader());//null


    }
}
