package byteCode.test;

public class MyTest22 {
    static{
        System.out.println("MyTest22 init...");
    }
    public static void main(String[] args){
        System.out.println(MyTest22.class.getClassLoader());

        System.out.println(MyTest13.class.getClassLoader());
    }
}
