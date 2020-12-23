package byteCode.test;

public class MyTest5{
        public static void main(String[] args){
            System.out.println(MyChild5.b);
        }
    }
interface MParent5{
    public static Thread thread= new Thread() {
        {
            System.out.println(" MParent5 invoke");
        }
    };
}
interface MyChild5 extends MParent5{     //接口属性默认是 public static final
    public static int b=6;
}
