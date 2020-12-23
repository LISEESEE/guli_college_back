package byteCode.test;

import com.sun.crypto.provider.AESKeyGenerator;

/**
 各加载器的路径是可以修改的，修改后会导致运行失败，ClassNotFoundExeception
 */
public class MyTest19{
    public static void main(String[] args){
        AESKeyGenerator aesKeyGenerator=new AESKeyGenerator();
        System.out.println(aesKeyGenerator.getClass().getClassLoader());//输出扩展类加载器
        System.out.println(MyTest19.class.getClassLoader());//输出应用类加载器
    }
}
