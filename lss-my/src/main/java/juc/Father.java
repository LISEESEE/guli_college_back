package juc;
/**
 * 父类的初始化<clinit>:
 * (1)j=methond();
 * (2)父类的静态代码块
 * 父类的实例方法：
 *  1、super()（最前）
 *  2、i = test();
 *  3、父类的非静态代码块
 *  4、父类的无参构造（最后）
 *
 *  非静态方法前面其实又一个默认的对象this
 *  this再构造器（或<init>）它表示的是正在创建的对象，因为这里是在创建Son对象，所以test()
 *  执行的是子类重写的代码(面向对象多态)
 *
 *  这里i=test()执行的是子类重写的test()方法
 */
public class Father {
    private int i = test();
    private static int j = method();
    static {
        System.out.print("1 ");
    }
    Father(){
        System.out.print("2 ");
    }
    {
        System.out.print("3 ");
    }
    int test(){
        System.out.print("4 ");
        return 1;
    }
    public static int method(){
        System.out.print("5 ");
        return 1;
    }
}
/**5 1 10 6 9 3 2 9 8 7
 * 子类的初始化<clinit>:
 * (1)j=methond();
 * (2)子类的静态代码块
 * 先初始化父类：5 1
 * 再初始化子类：10 6
 *
 * 子类的实例方法：
 * 1、super()（最前） 9 3 2
 * 2、i = test();    9
 * 3、子类的非静态代码块 8
 * 4、子类的无参构造（最后） 7
 */
class Son extends Father{
    private int i = test();
    private static int j = method();
    static {
        System.out.print("6 ");
    }
    Son(){
        System.out.print("7 ");
    }
    {
        System.out.print("8 ");
    }
    int test(){
        System.out.print("9 ");
        return 1;
    }
    public static int method(){
        System.out.print("10 ");
        return 1;
    }

    public static void main(String[] args) {
        Son s1 = new Son();
        System.out.println("=============");
        Son s2 = new Son();
        Son s3 = new Son();
        Son s4 = new Son();
    }
}