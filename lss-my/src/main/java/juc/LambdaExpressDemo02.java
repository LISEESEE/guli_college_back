package juc;
@FunctionalInterface
interface Foo{
//    public void saySomething();
    public Integer add(int x,int y);
    default int mul(int x,int y){
        return x*y;
    }
    static int div(int x,int y){
        return x/y;
    }
}

/**
 * 1、拷贝中括号，写死右箭头，落地大括号
 * 2、@FunctionalInterface
 * 3、default可以有多个
 */
public class LambdaExpressDemo02 {
    public static void main(String[] args) {
//        Foo foo = ()->{
//            System.out.println("Lambda Express");
//
//        };
//          foo.saySomething();
        Foo foo = Integer::sum;
        System.out.println(foo.add(3, 4));
        System.out.println(foo.mul(12, 4));
        System.out.println(Foo.div(10, 2));
    }
}
