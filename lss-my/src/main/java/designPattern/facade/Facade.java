package designPattern.facade;

public class Facade {
    SubSystemOne one;
    SubSystemTwo two;
    SubSystemThree three;
    SubSystemFour four;

    public Facade() {
        one = new SubSystemOne();
        two = new SubSystemTwo();
        three = new SubSystemThree();
        four = new SubSystemFour();
    }
    void methodA(){
        one.methodOne();;
        two.methodTwo();
        four.methodFour();
    }
    void methodB(){
        two.methodTwo();;
        three.methodThree();
    }
}
