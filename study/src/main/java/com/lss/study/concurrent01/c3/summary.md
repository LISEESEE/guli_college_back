1、创建线程对象Thread，默认有一个线程名，以Thread-开头，从0开始计数

2、如果在构造Thread的时候没有传递Runnable或者没有复写Thread的run方法，该Thread将不会调用任何东西，如果传递了Runnable
接口的实例，或者复写了Thread的run方法，则会执行该方法的逻辑单元

3、如果构造线程对象时未传入ThreadGroup，Thread会默认获取父线程的ThreadGroup作为该线程的ThreadGroup，此时
子线程和父线程将会在同一个ThreadGroup中

4、构造Thread的时候传入stackSize代表着该线程占用的stack大小，如果没有指定stacksize的大小，
默认是0，0代表着会忽略该参数，该参数会被JNI函数去使用 。需要注意：该参数有一些平台有效，在有些平台则无效