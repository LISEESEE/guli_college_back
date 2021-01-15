package com.lss.study.concurrent02.c12;

public class BalkingClient {
    public static void main(String[] args) {
        BalkingData balkingData = new BalkingData("C:\\Users\\lss\\Desktop\\xuexiao.txt", "===BEGIN====");
        new CustomerThread(balkingData).start();
        new WaiterThread(balkingData).start();
    }
}