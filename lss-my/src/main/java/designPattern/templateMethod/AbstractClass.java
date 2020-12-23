package designPattern.templateMethod;
/*
    抽象模板
 */
abstract class AbstractClass {
    abstract void primitiveOperation1();
    abstract void primitiveOperation2();
    void templateMethod(){
        primitiveOperation1();
        primitiveOperation2();
    }
}
