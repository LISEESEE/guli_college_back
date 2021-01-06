package com.lss.study.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则分组的处理
 */
public class Demo2 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("([a-z]+)([0-9]+)");
        Matcher m = p.matcher("aa232**ssdd541***sds541");

        while (m.find()){
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
        
    }
}
