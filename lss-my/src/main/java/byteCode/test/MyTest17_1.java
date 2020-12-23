package byteCode.test;

import java.io.*;

public class MyTest17_1 extends ClassLoader{
    private String classLoaderName;
    private String path;
    private final String fileExtension=".class";

    public MyTest17_1(String classLoaderName){
        super();        //将系统类当做该类的父加载器
        this.classLoaderName=classLoaderName;
    }
    public MyTest17_1(ClassLoader parent,String classLoaderName){
        super(parent);      //显式指定该类的父加载器
        this.classLoaderName=classLoaderName;
    }

    public void setPath(String path){
        this.path=path;
    }
    @Override
    public Class<?> findClass(String className){
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
        MyTest17_1 loader1=new MyTest17_1("loader1");
        loader1.path="C:\\Users\\lss\\Desktop";
        Class<?> clazz=loader1.loadClass("com.lss.MySample");
        System.out.println(clazz.hashCode());
        //MyCat是由加载MySample的加载器去加载的：
//        如果只删除classpath下的MyCat，则会报错，NoClassDefFoundError；
//        如果只删除calsspath下的MySample，则由自定义加载器加载桌面上的MySample，由系统应用加载器加载MyCat。
        Object  object=clazz.newInstance();
    }

}
