package com.xuchuangfeng.mechanism.pool;

import java.nio.channels.ServerSocketChannel;

/**
 * @author XuChuangFeng
 */
public interface Boss {

    /**
     * 加入一个新的ServerSocket
     *
     * @param serverChannel
     */
    void registerAcceptChannelTask(ServerSocketChannel serverChannel);
}
