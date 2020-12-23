package fansheDemo;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.Properties;

public class Main {
    public static void main(String[] args) throws Exception {
        //1.加载配置文件
        //1.1创建Properties对象
        Properties pro = new Properties();
        //1.2加载配置文件，转换为一个集合
        //1.2.1获取class目录下的配置文件
        ClassLoader classLoader = Main.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("pro.properties");
        pro.load(is);
        //2.获取配置文件的数据
        String className = pro.getProperty("className");
        String methodName = pro.getProperty("methodName");
        //3加载该类进内存
        Class cls = Class.forName(className);
        //4创建对象
        Object obj = cls.newInstance();
        //5获取方法对象
        Method method = cls.getMethod(methodName);
        method.invoke(obj);

    }
}
