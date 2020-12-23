package designPattern.builder;
/*
    抽象建造者类
 */
abstract class Builder {
    abstract void buildPartA();
    abstract void buildPartB();
    abstract Product getResult();
}
