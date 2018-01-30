package com.xuchuangfeng;

import org.jboss.netty.buffer.ChannelBuffer;
import org.jboss.netty.buffer.ChannelBuffers;

import java.util.Arrays;

/**
 * 使用netty的ChannelBuffer，可以实现动态扩容，不需要指定大小,但是占用的大小还是较多
 *
 * @author XuChuangFeng
 */
public class Test3 {

    public static void main(String[] args) {

        ChannelBuffer buffer = ChannelBuffers.dynamicBuffer();
        buffer.writeInt(101);

        byte[] bytes = new byte[buffer.writerIndex()];
        buffer.readBytes(bytes);

        System.out.println(Arrays.toString(bytes));

        "abc".getBytes();

        //================================================
        ChannelBuffer wrappedBuffer = ChannelBuffers.wrappedBuffer(bytes);
        System.out.println(wrappedBuffer.readInt());
        System.out.println(wrappedBuffer.readDouble());
    }

}
