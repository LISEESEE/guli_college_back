package byteCode.test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class Person{
    private Person person;

    public void setPerson(Person person) {
        this.person = person;
    }
}

public class MyTest20{
    public static void main(String[] args) throws ClassNotFoundException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        MyTest16 loader1=new MyTest16("loader1");
        MyTest16 loader2=new MyTest16("loader2");

        Class<?> clazz1=loader1.loadClass("Person");
        Class<?> clazz2=loader2.loadClass("Person");
        //clazz1和clazz均由应用类加载器加载的，第二次不会重新加载，结果为true
        System.out.println(clazz1==clazz2);

        Object object1=clazz1.getClasses();
        Object object2=clazz2.getClasses();

        Method method=clazz1.getMethod("setPerson",Object.class);
        method.invoke(object1,object2);

    }
}

