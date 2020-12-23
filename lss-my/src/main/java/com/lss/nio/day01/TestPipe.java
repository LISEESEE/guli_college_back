package com.lss.nio.day01;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * java NIO管道是两个线程时间的单向数据连接。Pipe有一个source通道和一个sink通道。数据会被写道sink通道，从source通道读取
 */
public class TestPipe {
    @Test
    public void test1() throws IOException {
        Pipe pipe = Pipe.open();
        ByteBuffer buf = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("通过单向管道发送数据".getBytes());
        buf.flip();
        sinkChannel.write(buf);
        //3读物缓冲区中的数据
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(),0,len));
        sourceChannel.close();
        sinkChannel.close();
    }

}
