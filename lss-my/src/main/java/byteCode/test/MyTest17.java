package byteCode.test;

import java.io.*;

/**
 创建自定义加载器，继承ClassLoader
 */
class MyCat{
    public MyCat(){
        System.out.println("MyCat is loaded..."+this.getClass().getClassLoader());
    }
}

class MySample{
    public MySample(){
        System.out.println("MySample is loaded..."+this.getClass().getClassLoader());
        new MyCat();
    }
}

public class MyTest17 extends ClassLoader{
    private String classLoaderName;
    private String path;
    private final String fileExtension=".class";

    public MyTest17(String classLoaderName){
        super();        //将系统类当做该类的父加载器
        this.classLoaderName=classLoaderName;
    }
    public MyTest17(ClassLoader parent,String classLoaderName){
        super(parent);      //显式指定该类的父加载器
        this.classLoaderName=classLoaderName;
    }

    public void setPath(String path){
        this.path=path;
    }
    @Override
    protected Class<?> findClass(String className){
        System.out.println("calssName="+className);
        className=className.replace(".", File.separator);
        byte[] data= new byte[0];
        try {
            data = loadClassData(className);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return defineClass(className,data,0,data.length); //define方法为父类方法
    }

    private byte[] loadClassData(String name) throws IOException {
        InputStream is=null;
        byte[] data=null;
        ByteArrayOutputStream baos=null;
        try{
            is=new FileInputStream(new File(this.path+name+this.fileExtension));
            baos=new ByteArrayOutputStream();
            int ch;
            while(-1!=(ch=is.read())){
                baos.write(ch);
            }
            data=baos.toByteArray();
        }catch(Exception e){
        }finally{
            is.close();
            baos.close();
            return data;
        }
    }
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        MyTest17 loader1=new MyTest17("loader1");
        Class<?> clazz=loader1.loadClass("byteCode.test.MySample");
        System.out.println(clazz.hashCode());
        //如果注释掉该行，就并不会实例化MySample对象，不会加载MyCat（可能预先加载）
        Object  object=clazz.newInstance(); //加载和实例化了MySample和MyCat
    }
}
