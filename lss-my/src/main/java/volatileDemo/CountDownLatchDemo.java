package volatileDemo;


import java.util.Objects;
import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
//        closeDoor();
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 国，被灭");
                countDownLatch.countDown();
            }, Objects.requireNonNull(CountryEnum.forEachCountryEnum(i)).getMessage()).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t ***********秦统一六国");
    }

    private static void closeDoor() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(6);
        for (int i = 1; i <= 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+"\t 上完自习，离开教室");
                countDownLatch.countDown();
            },String.valueOf(i)).start();
        }
        countDownLatch.await();
        System.out.println(Thread.currentThread().getName()+"\t ***********班长最后关门走人");
    }
}
enum CountryEnum{
    ONE(1,"齐"),TWO(2,"楚"),THREE(3,"燕"),
    FOUR(4,"韩"),FIVE(5,"赵"),SIX(6,"魏")
    ;
    private Integer retCode;
    private String message;

    CountryEnum(Integer retCode, String message) {
        this.retCode = retCode;
        this.message = message;
    }

    public Integer getRetCode() {
        return retCode;
    }

    public String getMessage() {
        return message;
    }
    public static CountryEnum forEachCountryEnum(int index){
        CountryEnum[] myArray = CountryEnum.values();
        for (CountryEnum e:myArray) {
            if (index == e.getRetCode()){
                return e;
            }
        }
        return null;
    }
}