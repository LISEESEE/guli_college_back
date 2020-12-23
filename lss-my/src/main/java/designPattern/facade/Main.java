package designPattern.facade;
/*
    外观模式：提供一个简单的接口，
 */
public class Main {
    public static void main(String[] args) {
        Facade f = new Facade();
        f.methodA();
        f.methodB();
    }
}


