package designPattern.factoryPattern;
//志愿者工厂
public class VolunFactory implements IFactory {
    @Override
    public LeiFeng createLeiFeng() {
        return new LeiFeng("志愿者");
    }
}
