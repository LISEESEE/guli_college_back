package volatileDemo;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

public class ContainerNotSafeDemo {
    public static void main(String[] args) {
        listNotSafe();
        setNotSafe();

        hashMapNotSafe();
/**
         * 1、故障现象
         *      java.util.ConcurrentModificationException
         * 2、导致原因
         *      并发争抢修改导致。一个人正在写入，另一个人过来抢夺，导致数据不一致异常，并发修改异常。
         * 3、解决方案：
         *      3.1 new Vector();
         *      3.2 Collections.synchronizedList(new ArrayList());
         *      3.3 new CopyOnWriteArrayList()
         * 4、优化建议（同样的错误不犯第二次）
         */
        /**
         * 笔记：
         * 写时复制
         * CopyOnWrite容器即写时复制的容器，往一个容器添加元素的时候，不直接往当前容器Object[]添加，
         * 而是先将当前容器Object[]进行copy，复制出一个新的容器Object[] new Elements里添加元素，添加
         * 元素之后，而将原容器的引用指向新的容器setArray(newElement);这样的好处是可以对CopyOnWrite容器
         * 进行并发的读，而不需要加锁，因为当前容器不会添加任何元素。所以CopyOnWrite容器也是一个读写分离的思想，
         * 读和写不同的容器。
         *  public boolean add(E e) {
         *         final ReentrantLock lock = this.lock;
         *         lock.lock();
         *         try {
         *             Object[] elements = getArray();
         *             int len = elements.length;
         *             Object[] newElements = Arrays.copyOf(elements, len + 1);
         *             newElements[len] = e;
         *             setArray(newElements);
         *             return true;
         *         } finally {
         *             lock.unlock();
         *         }
         *     }
         */
    }

    private static void hashMapNotSafe() {
        Map<String ,String> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0,8));
                System.out.println(map);
            }).start();
        }
    }

    private static void setNotSafe() {
        Set<Integer> list = new CopyOnWriteArraySet<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(random.nextInt(10));
                System.out.println(list);
            }).start();
        }
    }

    private static void listNotSafe() {
        //        List<Integer> list = new ArrayList<>();
//        List<Integer> list = Collections.synchronizedList(new ArrayList<>());
//        new CopyOnWriteArraySet<>();
//        new HashSet<>(10);
        List<Integer> list = new CopyOnWriteArrayList();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            new Thread(() -> {
                list.add(random.nextInt(10));
                System.out.println(list);
            }).start();
        }
    }
}
