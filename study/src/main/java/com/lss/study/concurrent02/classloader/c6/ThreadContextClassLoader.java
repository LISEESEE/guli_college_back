package com.lss.study.concurrent02.classloader.c6;

import com.lss.study.concurrent02.classloader.c3.MyClassLoader;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//打破双亲委派机制
public class ThreadContextClassLoader {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        System.out.println(contextClassLoader);

        Thread.currentThread().setContextClassLoader(new MyClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());


        Class.forName("com.mysql.jdbc.Driver");//(---)
        Connection conn = DriverManager.getConnection("");
    }
}
