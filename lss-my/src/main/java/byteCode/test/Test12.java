package byteCode.test;
class CL{
    static {
        System.out.println("Class CL");
    }
}
public class Test12 {
    public static void main(String[] args) throws ClassNotFoundException {
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        Class<?> clazz = loader.loadClass("byteCode.test.CL");
        System.out.println(clazz);
        System.out.println("-----");
        clazz = Class.forName("byteCode.test.CL");
        System.out.println(clazz);
    }
}
