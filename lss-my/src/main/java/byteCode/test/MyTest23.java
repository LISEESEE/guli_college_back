package byteCode.test;

import sun.misc.Launcher;

public class MyTest23 {
    public static void main(String[] args){
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(ClassLoader.class.getClassLoader());
        System.out.println(Launcher.class.getClassLoader());

        //下面的系统属性指定系统类加载器，默认是AppClassLoader
        System.out.println(System.getProperty("java.system.class.loader"));
    }
}
