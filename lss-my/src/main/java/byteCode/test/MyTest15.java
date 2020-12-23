package byteCode.test;

public class MyTest15 {
    public static void main(String[] args){
        String[] strings=new String[2];
        System.out.println(strings.getClass()); //class [Ljava.lang.String;
        System.out.println(strings.getClass().getClassLoader());    //输出null

        MyTest15[] mytest15=new MyTest15[2];
        System.out.println(mytest15.getClass().getClassLoader());   //输出应用类加载器

        int[] arr=new int[2];
        System.out.println(arr.getClass().getClassLoader());        //输出null，此null非彼null
    }
}
