package designPattern.builder;
/*
    建造者模式，将一个复杂对象的创建与它的表示分离，使得同样的建造过程可以创建不同的表示。
 */
public class Main {
    public static void main(String[] args) {
        Director director = new Director();
        Builder b1 = new Builder1();
        Builder b2 = new Builder2();
        director.construct(b1);
        Product p1 = b1.getResult();
        p1.show();
        director.construct(b2);
        Product p2 = b2.getResult();
        p2.show();
    }
}
