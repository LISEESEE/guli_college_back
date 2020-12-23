package com.lss.nio.day01;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

public class TestNonBlockingNIO {
    @Test
    public void client() throws IOException {
        //1获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost",9898));
        //切换非阻塞模式
        socketChannel.configureBlocking(false);
        //3分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //4发送数据给服务器
        buf.put(new Date().toString().getBytes());
        buf.flip();
        socketChannel.write(buf);
        buf.clear();
        //5关闭通道
        socketChannel.close();
    }
    //服务器
    @Test
    public void server() throws IOException {
        //1获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        //2切换非阻塞模式
        ssChannel.configureBlocking(false);
        //3绑定连接
        ssChannel.bind(new InetSocketAddress(9898));
        //4获取选择器
        Selector selector = Selector.open();
        //5将通道注册到选择器上，并指定“监听接收事件”
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
       //6轮询式的获取选择器上已经准备就绪的事件
        while(selector.select()>0){
            //7获取当前选择器中所有的选择键（已经就绪的监听事件）
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while(iterator.hasNext()){
                //8获取准备就绪的事件
                SelectionKey sk = iterator.next();
                //9判断具体是什么时间准备就绪
                if(sk.isAcceptable()){
                    //10若接受就绪，获取客户端连接
                    SocketChannel socketChannel = ssChannel.accept();
                    //11切换非阻塞模式
                    socketChannel.configureBlocking(false);
                    //12将该通道注册到选择器上
                    socketChannel.register(selector,SelectionKey.OP_READ);
                } else if (sk.isReadable()){
                    //13获取当前选择器上读就绪状态的通道
                    SocketChannel socketChannel = (SocketChannel) sk.channel();
                    //14读取数据
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while((len = socketChannel.read(buf))>0){
                        buf.flip();
                        System.out.println(new String(buf.array(),0,len));
                    }
                    //15取消选择键SelectKey
                    iterator.remove();
                }

            }
        }
    }
}
