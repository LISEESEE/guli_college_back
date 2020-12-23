package designPattern.decoratorPattern.v1;

public class ConcreteDecoratorA extends Decorator{
    private String addedState;

     private Component base = new ConcreteComponent();

    @Override
    public void operation() {
        base.operation();
        System.out.println("具体封装对象A的操作");
    }
}
