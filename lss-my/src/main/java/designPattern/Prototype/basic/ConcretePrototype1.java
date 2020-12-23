package designPattern.Prototype.basic;

public class ConcretePrototype1 extends Prototype {
    public static int classFlag = 1;

    /**
     * 克隆自身方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        return (ConcretePrototype1) super.clone();
    }
}