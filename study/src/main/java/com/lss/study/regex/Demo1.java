package com.lss.study.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\w+");
        Matcher m = p.matcher("aaa2321");
        System.out.println(m.matches());
        System.out.println(m.find());


    }
}
