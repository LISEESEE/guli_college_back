package com.lss.study.regex;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo3 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher("aa232**ssdd541***sds541");
        //替换
        System.out.println(m.replaceAll("#"));

        String str = "a1232b213c2323";
        String[] split = str.split("\\d+");
        System.out.println(Arrays.toString(split));
    }
}
