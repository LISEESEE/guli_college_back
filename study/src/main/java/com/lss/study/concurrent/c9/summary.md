sleep()和wait()的区别：
1.sleep()是Thread()的方法，而wait()是Object()的方法
2.sleep()不会释放Object的监控，而wait()会释放监控并把Object monitor加到队列中
3.sleep()不依赖monitor，而wait()需要
4.sleep()不需要wakeup，而wait()需要