package designPattern.strategyPattern;

/**
 * 策略模式
 */
public class Main {
    public static void main(String[] args) {
        new Context(new StrategyA()).contextInterface();
        new Context(new StrategyB()).contextInterface();
        new Context(new StrategyC()).contextInterface();
    }
}
