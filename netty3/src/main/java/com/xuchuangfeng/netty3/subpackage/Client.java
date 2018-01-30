package com.xuchuangfeng.netty3.subpackage;

import java.net.Socket;
import java.nio.ByteBuffer;

/**
 * @author XuChuangFeng
 */
public class Client {

    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("127.0.0.1", 10000);

        byte[] bytes = "hello".getBytes();

        ByteBuffer buffer = ByteBuffer.allocate(4 + bytes.length);
        buffer.putInt(bytes.length);
        buffer.put(bytes);

        byte[] array = buffer.array();

        for (int i = 0; i < 1000; i++) {
            socket.getOutputStream().write(array);
        }

        socket.close();
    }

}
