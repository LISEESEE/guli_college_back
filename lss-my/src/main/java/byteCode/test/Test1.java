package byteCode.test;

public class Test1 {
    public static void main(String[] args) {
       new MyParent1();
    }

}
interface MyGrandpa {
    public static Thread th = new Thread() {
        {
            System.out.println("MyGrandpa");
        }
    };
}
interface MyParent extends MyGrandpa {

    public static Thread th = new Thread() {
        {
            System.out.println("MyParent");
        }
    };
}
class MyGrandpa1 {
    static {
        System.out.println("MyGrandpa1 static");
    }
    {
        System.out.println("MyGrandpa1 ddd");
    }
    MyGrandpa1(){
        System.out.println("MyGrandpa1");
    }
}
class MyParent1 extends MyGrandpa1 {
    static {
        System.out.println("static");
    }
    {
        System.out.println("ddd");
    }

    public MyParent1() {
        System.out.println("MyParent1()");
    }
}