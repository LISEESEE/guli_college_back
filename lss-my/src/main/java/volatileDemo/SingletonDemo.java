package volatileDemo;


public class SingletonDemo {
    //禁止指令重排序
    private static volatile SingletonDemo instance = null;

    public SingletonDemo() {
        System.out.println("SingletonDemo构造");
    }
    //DCL
    public static SingletonDemo getInstance() {
        if (instance == null){
            synchronized (SingletonDemo.class){
                if (instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(SingletonDemo::getInstance,String.valueOf(i)).start();
            new Thread(Singleton::getInstance,String.valueOf(i)).start();
        }
    }
}

/**
 * 在内部类被加载和初始化时，才创建Instance对象
 * 静态内部类不会随着外部类的加载和初始化而初始化，它是要单独去加载和初始化的。
 * 因为是在内部类加载和初始化时创建的，因此线程是安全的
 */
class Singleton{
    public Singleton() {
        System.out.println("Si");
    }
    private static class Inner{

        private static final Singleton s = new Singleton();
    }
    public static Singleton getInstance(){
        return Inner.s;
    }
}