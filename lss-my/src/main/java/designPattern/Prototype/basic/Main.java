package designPattern.Prototype.basic;

public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Prototype prototype1 = new ConcretePrototype1();
        ConcretePrototype1 concretePrototype1 = (ConcretePrototype1) prototype1.clone();
        System.out.println(concretePrototype1.classFlag);
        Prototype prototype2 = new ConcretePrototype2();
        ConcretePrototype2 concretePrototype2 = (ConcretePrototype2) prototype2.clone();
        System.out.println(concretePrototype2.classFlag);
    }
}
