package juc;
//递归
public class TestStep1 {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(f(40));//165580141
        long end = System.currentTimeMillis();
        System.out.println(end-start);//431ms
    }
    static int f(int n){
        if (n<1){
            throw new IllegalArgumentException(n+"不能小于1");
        }
        if (n==1||n==2){
            return n;
        }
        return f(n-2)+f(n-1);
    }
}
class TestStep2{
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        System.out.println(loop(40));//165580141
        long end = System.currentTimeMillis();
        System.out.println(end-start);//1ms
    }
    static int loop(int n){
        if (n<1){
            throw new IllegalArgumentException(n+"不能小于1");
        }
        if (n==1||n==2){
            return n;
        }
        int one = 2;//初始化为走到第二级台阶的走法
        int two = 1;//初始化为走到第一级台阶的走法
        int sum = 0;
        for (int i = 3; i <=n ; i++) {
            //最后kua2步，最后跨1步的走法
            sum = two + one;
            two = one;
            one = sum;
        }
        return sum;
    }
}