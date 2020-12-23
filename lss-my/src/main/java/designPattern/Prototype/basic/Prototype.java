package designPattern.Prototype.basic;

//原型模式
public abstract class Prototype implements Cloneable {
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
