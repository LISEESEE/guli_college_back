package designPattern.decoratorPattern.v1;

/**
 * 装饰者模式
 */
public class Main {
    public static void main(String[] args) {
        ConcreteComponent c = new ConcreteComponent();
        ConcreteDecoratorA c1 = new ConcreteDecoratorA();
        ConcreteDecoratorB c2 = new ConcreteDecoratorB();
        c1.setComponent(c);
        c2.setComponent(c1);
        c2.operation();
    }
}
