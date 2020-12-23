package byteCode.test;

import java.lang.reflect.Method;

class MyPerson {
    private Person person;
    public void setPerson(Object object){
        this.person=(Person)object;
    }
}

public class MyTest21 {
    public static void main(String[] args) throws Exception{
        MyTest16 loader1=new MyTest16("loader1");
        MyTest16 loader2=new MyTest16("loader2");
        loader1.setPath("C:\\Users\\lss\\Desktop");
        loader2.setPath("C:\\Users\\lss\\Desktop");
        //删掉classpath下的Person类
        Class<?> clazz1=loader1.loadClass("Person");
        Class<?> clazz2=loader2.loadClass("Person");
        //clazz1和clazz由loader1和loader2加载，结果为false
        System.out.println(clazz1==clazz2);

        Object object1=clazz1.newInstance();
        Object object2=clazz2.newInstance();

        Method method=clazz1.getMethod("setPerson",Object.class);
        //此处报错，loader1和loader2所处不用的命名空间
        method.invoke(object1,object2);
    }
}
