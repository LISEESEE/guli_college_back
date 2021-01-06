package com.lss.study.regex;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WebSpiderTest {
    public static void main(String[] args) {
        String urlContent = getUrlContent();

//        Pattern p = Pattern.compile("<a[\\s\\S]+?</a>");
        Pattern p = Pattern.compile("href=\"([\\w\\s./:]+?)\"");
        Matcher m = p.matcher(urlContent);
        while (m.find()){
            System.out.println(m.group());
        }


    }

    private static String getUrlContent() {
        StringBuilder stringBuilder = new StringBuilder();
        try{
            URL url = new URL("https://www.163.com");
            BufferedReader reader = new BufferedReader(new InputStreamReader(url.openStream(), Charset.forName("gbk")));
            String temp = "";

            while ((temp=reader.readLine())!=null){
                stringBuilder.append(temp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
