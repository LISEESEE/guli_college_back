package designPattern.builder;
/*
    具体建造者
 */
public class Builder1 extends Builder{
    private Product product = new Product();

    @Override
    void buildPartA() {
        product.add("部件A");
    }

    @Override
    void buildPartB() {
        product.add("部件B");
    }

    @Override
    Product getResult() {
        return product;
    }
}
