package com.lss.memory;

import java.util.ArrayList;
import java.util.List;

/**
 * 虚拟机栈：stack frame 栈帧
 * 程序计数器（Program Counter） ：和虚拟机栈都是线程私有的
 * 本地方法栈：主要用于处理本地方法
 * 堆：jvm管理的最大一块内存空间（所有线程共享），与堆相关的一个重要概念是垃圾收集器。现代几乎
 *      所有的垃圾收集器都是采用的分代收集算法。所以堆空间也基于这一点进行了相应的划分：新生代与老年代。
 *      Eden空间，From Survivor空间与To Survivor空间
 * 方法区：存储元信息。永久代，从JDK2.8开始，已经彻底放弃了永久代，使用元空间（meta space）
 * 运行时常量池：方法区的一部分内容
 * 直接内存：Direct Memory，与java NIO密切相关，jvm通过堆上的DirectByteBuffer来操作直接内存。
 *
 *  关于java对象创建的过程：
 *  new 关键字创建对象的3个步骤：
 *  1、在堆内存中创建出对象的实例。
 *  2、为对象的实例成员变量赋初值。
 *  3、将对象的引用返回。
 *
 *  两种方式：
 *  指针碰撞（前提是堆中的空间通过一个指针进行分割，一侧是已经被占用的空间，另一侧是未被占用的空间）
 *  空闲列表（前提是堆内存空间中已被使用与未被使用的空间是交织在一起的，这时，虚拟机就需要通过一个列表来记录
 *  哪些空间是可以使用的，哪些空间是已被使用的，接下来找出可以容纳下新创建对象的且未被使用的空间，在此空间存
 *  放该对象，同时还要修改列表上的记录）
 *
 *  对象在内存中的布局：
 *  1、对象头
 *  2、实例数据（即我们在一个类中所声明的各项信息）
 *  3、对齐填充（可选）
 *
 *  引用访问对象的方式：
 *  1、使用句柄的方式。
 *  2、使用直接指针的方式
 *
 *
 */
public class MyTest1 {
    //-Xms5m -Xmx5m -XX:+HeapDumpOnOutOfMemoryError
    //分析工具：jvisualvm
    public static void main(String[] args) {
        List<MyTest1> list = new ArrayList<>();
        for (;;){
            list.add(new MyTest1());
            System.gc();
        }
    }
}
