package queueDemo;

import java.util.concurrent.*;

/**
 * 第四种获得/使用java多线程的方式，线程池
 */
public class MyThreadPoolDemo {
    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(3),
                Executors.defaultThreadFactory(),
//                new ThreadPoolExecutor.AbortPolicy()
//                new ThreadPoolExecutor.CallerRunsPolicy()//回退到调用者
//                new ThreadPoolExecutor.DiscardOldestPolicy()
                new ThreadPoolExecutor.DiscardPolicy()
        );
        try{
            for (int i = 0; i < 13; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }

    private static void threadPoolInit() {
        //        ExecutorService threadPool = Executors.newFixedThreadPool(5);//一池5个处理线程
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();//一池1个处理线程
        ExecutorService threadPool = Executors.newCachedThreadPool();//一池N个处理线程
        try{
            for (int i = 0; i < 10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"办理业务");
                });
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            threadPool.shutdown();
        }
    }
}
