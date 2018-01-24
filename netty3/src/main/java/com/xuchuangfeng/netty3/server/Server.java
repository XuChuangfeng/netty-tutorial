package com.xuchuangfeng.netty3.server;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;
import org.jboss.netty.handler.codec.string.StringDecoder;
import org.jboss.netty.handler.codec.string.StringEncoder;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author XuChuangFeng
 */
public class Server {

    public static void main(String[] args) {
        // 服务类
        ServerBootstrap bootstrap = new ServerBootstrap();

        //boss线程监听端口，worker线程负责数据读写
        ExecutorService boss = Executors.newCachedThreadPool();
        ExecutorService worker = Executors.newCachedThreadPool();

        // 设置niosocket工厂
        bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));

        // 设置管道的工厂
        bootstrap.setPipelineFactory(() -> {
            ChannelPipeline pipeline = Channels.pipeline();
            // 支持接收到数据直接封装成String，UpStreamHandler对上行数据做处理
            pipeline.addLast("decoder", new StringDecoder());
            // 支持回写数据的时候直接使用String，DownStreamHandler对下行数据做处理
            pipeline.addLast("encoder", new StringEncoder());
            pipeline.addLast("helloHandler", new HelloHandler());
            return pipeline;
        });
        bootstrap.bind(new InetSocketAddress(10000));
        System.out.println("start!!!");
    }
}