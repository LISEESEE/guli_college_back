package juc;

public class Exam5 {
    static int s;//成员变量，类变量
    int i;//成员变量，实例变量
    int j;//成员变量，实例变量
    {
        int i = 1;//非静态代码块中的局部变量i
        i++;
        j++;
        s++;
    }
    public void test(int j){//形参，局部变量，j
        j++;
        i++;
        s++;
    }

    public static void main(String[] args) {//形参，局部变量，args
        Exam5 obj1 = new Exam5();//局部变量，obj1    0，1，1
        Exam5 obj2 = new Exam5();//局部变量，obj1    0，1，2
//        obj1.test(10);                        // 1，1，3
//        obj1.test(20);                         //2，1，4
//        obj2.test(30);                         //1，1，5
        System.out.println(obj1.i+","+obj1.j+","+obj1.s);
//        System.out.println(obj2.i+","+obj2.j+","+obj2.s);
    }
}
