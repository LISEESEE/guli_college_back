package com.lss.nio.day01;


import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * 一、通道（channel）：用于源节点与目标节点得连接。在NIO中负责缓冲区中数据得传输。Channel本身不存储数据，因此需要配合缓冲区进行传输
 * 二、通道的主要实现类：
 *     java.nio.channels.Channel接口：
 *              |--FileChannel
 *              |--SocketChannel
 *              |--ServerSocketChannel
 *              |--DatagramChannel
 * 三、获取通道
 * 1、Java针对支持通道的类提供了getChannel()方法
 *        本地IO：
 *        FileInputStream/FileOutputStream
 *        RandomAccessFile
 *        网络IO:
 *        Socket
 *        ServerSocket
 *        DatagramSocket
 * 2、在JDK1.7中的NIO.2针对各个通道提供了静态方法open()
 * 3、在JDK1.7中的NIO.2的Files工具类的newByteChannel()
 *
 * 四、通道之间的数据传输
 * transferForm()
 * transferTo()
 *
 * 五、分散（Scatter）与聚集（Gather）
 * 分散读取（Scattering Reads）：将通道中的数据分散到多个缓冲区中
 * 聚集写入（Gathering Writes）：将多个缓冲区的数据聚集到通道中
 *
 * 六、字符集：Charset
 * 编码：字符串 ->字节数组
 * 解码：字节数组 ->字符串
 */
public class TestChannel {
    @Test
    public void test1() throws IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //1、获取通道
        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try{

            fis = new FileInputStream("1.jpg");
            fos = new FileOutputStream("2.jpg");
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();
            //2、分配指定大小的缓冲区
            ByteBuffer buf = ByteBuffer.allocate(1024);
            //3、将通道中的数据存入缓冲区中
            while(inChannel.read(buf)!=-1){
                buf.flip();//切换读取数据的模式
                //4将缓冲区中的数据写入通道中
                outChannel.write(buf);
                buf.clear();//清空缓冲区
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            if (outChannel!=null){
                outChannel.close();
            }
            if (inChannel!=null){
                inChannel.close();
            }
            if (fos!=null){
                fos.close();
            }
            if (fis!=null){
                fis.close();
            }
        }
    }
    @Test
    public void test2() throws Exception {
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW,StandardOpenOption.READ);
        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY,0,inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE,0,inChannel.size());
        //直接对缓冲区进行数据的读写操作
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);
        inChannel.close();
        outChannel.close();
    }
    @Test
    public void test3() throws Exception{
        //通道之间的数据传输（直接缓冲区
        // ）
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("4.jpg"),StandardOpenOption.WRITE,StandardOpenOption.CREATE_NEW,StandardOpenOption.READ);
        inChannel.transferTo(0,inChannel.size(),outChannel);
        //相同效果
//        outChannel.transferFrom(inChannel,0,inChannel.size());
        inChannel.close();
        outChannel.close();
    }
    @Test
    public void test4() throws IOException{
        RandomAccessFile raf1 = new RandomAccessFile("1.txt","rw");
        //1、获取通道
        FileChannel channel1 = raf1.getChannel();
        //2、分配指定大小的缓冲区
        ByteBuffer buf1 = ByteBuffer.allocate(100);
        ByteBuffer buf2 = ByteBuffer.allocate(1024);
        //分散读取
        ByteBuffer[] bufs = {buf1,buf2};
        channel1.read(bufs);
        for (ByteBuffer byteBuffer : bufs){
            byteBuffer.flip();
        }
        System.out.println(new String(bufs[0].array(),0,bufs[0].limit()));
        System.out.println("----------------");
        System.out.println(new String(bufs[1].array(),0,bufs[1].limit()));

        //4、聚集写入
        RandomAccessFile raf2 = new RandomAccessFile("2.txt","rw");
        FileChannel channel2 = raf2.getChannel();

        channel2.write(bufs);
    }
    @Test
    public void test5(){
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String,Charset>> set = map.entrySet();
        for (Map.Entry<String,Charset> entry : set){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
    @Test
    public void test6() throws CharacterCodingException {
        Charset cs1 = Charset.forName("GBK");
        //获取编码器
        CharsetEncoder ce = cs1.newEncoder();
        //获取解码器
        CharsetDecoder cd = cs1.newDecoder();
        CharBuffer cBuf = CharBuffer.allocate(1024000000);
        cBuf.put("吊带裤！");
        cBuf.flip();
        //编码
        ByteBuffer bBuf = ce.encode(cBuf);
        for (int i = 0; i<8;i++){
            System.out.println(bBuf.get());
        }
        //编码
        bBuf.flip();
        CharBuffer cBuf2 = cd.decode(bBuf);
        System.out.println(cBuf2.toString());

        System.out.println("-------------");

        Charset cs2 = Charset.forName("UTF-8");
        CharBuffer cBuf3 = cs2.decode(bBuf);
        System.out.println(cBuf3.toString());
    }
}
