package designPattern.decoratorPattern.v1;

public class ConcreteDecoratorB extends Decorator{

    private Component base = new ConcreteComponent();

    @Override
    public void operation() {
        base.operation();
        addBehavior();
        System.out.println("具体封装对象B的操作");
    }

    private void addBehavior() {
        System.out.println("对象B的行为");
    }

}
