package designPattern.factoryPattern;
//也可定义成抽象对象
public class LeiFeng {
    private String method;
    public void Sweep(){
        System.out.println(method+"扫地");
    }
    public void Wash(){
        System.out.println(method+"洗衣");
    }
    public void BuyRice(){
        System.out.println(method+"买米");
    }

    public LeiFeng(String method) {
        this.method = method;
    }
}
