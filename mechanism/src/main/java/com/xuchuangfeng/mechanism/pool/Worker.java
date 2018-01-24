package com.xuchuangfeng.mechanism.pool;

import java.nio.channels.SocketChannel;

/**
 * @author XuChuangFeng
 */
public interface Worker {

    /**
     * 加入一个新的客户端会话
     *
     * @param channel
     */
    void registerNewChannelTask(SocketChannel channel);

}
