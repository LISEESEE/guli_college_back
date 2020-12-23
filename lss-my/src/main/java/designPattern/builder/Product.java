package designPattern.builder;

import java.util.ArrayList;
/*
    产品类
 */
public class Product {
    ArrayList<String> parts = new ArrayList<>();
    public void add(String part){
        parts.add(part);
    }
    public void show(){
        System.out.println("show");
        for (String part : parts) {
            System.out.println(part);
        }
    }
}
