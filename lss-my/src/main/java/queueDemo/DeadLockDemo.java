package queueDemo;

import java.util.concurrent.TimeUnit;

class HoldLockThread implements Runnable{
    private String lockA;
    private String lockB;

    public HoldLockThread(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
        synchronized (lockA){
            System.out.println(Thread.currentThread().getName()+"自己持有"+lockA+"尝试获得"+lockB);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (lockB){
                System.out.println(Thread.currentThread().getName()+"自己持有"+lockB+"尝试获得"+lockA);

            }
        }
    }
}

/**
 * 死锁是指两个或两个以上的进程在执行过程中，因争夺资源而造成的一种互相等待的现象。
 * 若无外力干涉那么他们都将无法推进下去。
 *
 * 解决：jps命令定位进程号
 *       jstack找到死锁查看
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String lockA = "lockA";
        String lockB = "lockB";
        new Thread(new HoldLockThread(lockA,lockB),"aaa").start();
        new Thread(new HoldLockThread(lockB,lockA),"bbb").start();
    }
}
