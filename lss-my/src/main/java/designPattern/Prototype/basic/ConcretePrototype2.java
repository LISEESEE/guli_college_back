package designPattern.Prototype.basic;

public class ConcretePrototype2 extends Prototype {
    public static int classFlag = 2;

    /**
     * 克隆自身方法
     *
     * @return
     * @throws CloneNotSupportedException
     */
    public Object clone() throws CloneNotSupportedException {
        return (ConcretePrototype2) super.clone();
    }
}