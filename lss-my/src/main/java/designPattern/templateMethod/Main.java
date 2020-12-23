package designPattern.templateMethod;
/*
    模板方法：通过把不变行为搬移到超类，去除子类中的重复代码来体现它的优势。（代码复用）
 */
public class Main {
    public static void main(String[] args) {
        AbstractClass c;
        c = new ConcreteClassA();
        c.templateMethod();
        c = new ConcreteClassB();
        c.templateMethod();
    }
}
