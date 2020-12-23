package oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class MetaspaceOOMTest {
    //Caused by: java.lang.OutOfMemoryError: Metaspace
    //-XX:MetaspaceSize=8m -XX:MaxMetaspaceSize=10m
    static class OOMTest{ }
    public static void main(String[] args) {
        int i = 0;//模拟计数多少次以后发生异常
        try{
            while (true){
                i++;
                Enhancer en = new Enhancer();
                en.setSuperclass(OOMTest.class);
                en.setUseCache(false);
                en.setCallback(new MethodInterceptor() {
                    @Override
                    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                        return methodProxy.invokeSuper(o,args);
                    }
                });
                en.create();
            }
        }catch (Throwable e){
            System.out.println("多少次后发生了异常"+i);
            e.printStackTrace();
        }
    }
}
