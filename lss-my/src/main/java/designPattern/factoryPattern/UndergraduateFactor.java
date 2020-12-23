package designPattern.factoryPattern;

public class UndergraduateFactor implements IFactory {
    @Override
    public LeiFeng createLeiFeng() {
        return new LeiFeng("大学生");
    }
}
