package designPattern.factoryPattern;

public class Main {
    public static void main(String[] args) {
        new UndergraduateFactor().createLeiFeng().BuyRice();
        new VolunFactory().createLeiFeng().BuyRice();
    }
}
