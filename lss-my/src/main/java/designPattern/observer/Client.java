package designPattern.observer;

public class Client {
    public static void main(String[] args) {
        AbstractSubject subject = new ConcreteSubject();
        subject.addObserver(() -> System.out.println("A同学您的aPP需要更新"));
        subject.addObserver(() -> System.out.println("B同学您的aPP需要更新"));
        subject.addObserver(() -> System.out.println("C同学您的aPP需要更新"));
        subject.notification();
    }
}
