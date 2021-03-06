package com.xuchuangfeng.mechanism;

import com.xuchuangfeng.mechanism.pool.NioSelectorRunnablePool;

import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

/**
 * @author XuChuangFeng
 */
public class Start {

    public static void main(String[] args) {
        // 初始化线程，线程池会在构造方法中启动boss跟worker线程，进行poll
        NioSelectorRunnablePool nioSelectorRunnablePool = new NioSelectorRunnablePool(Executors.newCachedThreadPool(), Executors.newCachedThreadPool());

        // 获取服务类
        ServerBootstrap bootstrap = new ServerBootstrap(nioSelectorRunnablePool);

        // 绑定端口
        bootstrap.bind(new InetSocketAddress(10000));

        System.out.println("start");
    }
}
