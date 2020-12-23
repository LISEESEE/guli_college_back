package byteCode.test;

public class MyTest18 {
    public static void main(String[] args){
        System.out.println(System.getProperty("sun.boot.class.path"));//根加载器路径
        System.out.println(System.getProperty("java.ext.dirs"));//扩展类加载器路径
        System.out.println(System.getProperty("java.calss.path"));//应用类加载器路径
    }
}
