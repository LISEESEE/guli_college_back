package queueDemo;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：synchronized和Lock有什么区别？用新的Lock有什么好处？你举例说说
 * 1、原始构成
 *  synchronized是关键字属于jvm层面，
 *      moniterenter（底层是通过monitor对象来完成，其实wait/notify等方法也依赖于monitor对象只有在同步块或者方法中才能调用wait/notify等方法）
 *  Lock是具体类juc是api层面的锁
 *  2、使用方法
 *  synchronized不需要用户去手动释放锁，当synchronized代码执行完后自动让线程释放对锁的占用
 *  ReentrantLock则需要用户去手动释放锁若没有主动释放锁，就可能导致出现死锁现象
 *  需要lock()和unlock()方法来配合try/finally语句块来完成
 *  3、等待是否可以中断
 *   synchronized不可中断，除非抛出异常或者正常运行完成
 *   ReentrantLock可中断，1、设置超时方法tryLock(Long timeout,TimeUnit unit)
 *                       2、LockInterruptibly()放代码块中，调用interrupt()方法可中断
 *  4、加锁是否公平
 *    synchronized非公平锁
 *    ReentrantLock两者都可以，默认非公平锁，构造方法可以传入boolean值，true为公平锁，false为非公平锁
 *  5、锁绑定多个条件condition
 *      synchronized没有
 *      ReentrantLock用来实现分组唤醒需要唤醒的线程们，可以精确唤醒，而不是像synchronized要么随机唤醒一个要么全部唤醒
 */
class ShareResource{
    private int number = 1;//A:1 B:2 C:3
    private Lock lock = new ReentrantLock();
    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();
    public void print5(){
        lock.lock();
        try{
            while (number!=1){
                c1.await();

            }
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName()+"相册"+i);
            }
            //3通知
            number = 2;
            c2.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            while (number!=2){
                c2.await();

            }
            for (int i = 0; i < 10; i++) {
                System.out.println(Thread.currentThread().getName()+"线程"+i);
            }
            //3通知
            number = 3;
            c3.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
    public void print15(){
        lock.lock();
        try{
            while (number!=3){
                c3.await();

            }
            for (int i = 0; i < 15; i++) {
                System.out.println(Thread.currentThread().getName()+"线程"+i);
            }
            //3通知
            number = 1;
            c1.signal();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
public class SyncAndReentrantLockDemo {
    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print5();
            }
        },"A").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print10();
            }
        },"B").start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                shareResource.print15();
            }
        },"C").start();
    }
}
