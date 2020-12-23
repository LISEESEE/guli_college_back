package byteCode.test;

public class MyTest24 {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());//应用类加载器
        System.out.println(Thread.class.getClassLoader());//null 根类加载器
    }
}
