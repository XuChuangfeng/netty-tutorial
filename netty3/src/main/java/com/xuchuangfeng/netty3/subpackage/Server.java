package com.xuchuangfeng.netty3.subpackage;

import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelPipeline;
import org.jboss.netty.channel.Channels;
import org.jboss.netty.channel.socket.nio.NioServerSocketChannelFactory;

import java.net.InetSocketAddress;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 1、为什么FrameDecoder return的对象就是往下传递的对象 (还是调用了sendUpstream)
 * 2、buffer里面数据未被读取完怎么办？ (cumulation缓存)
 * 3、为什么return null就可以缓存buffer (cumulation缓存)
 * 3、FrameDecoder里面的cumulation其实就是一个缓存的buffer对象
 * 4、把长度定义的很大Integer.max，这种数据包，通常被称为socket攻击，字节流式攻击
 *
 * @author XuChuangFeng
 */
public class Server {

	public static void main(String[] args) {
		//服务类
		ServerBootstrap bootstrap = new ServerBootstrap();
		//boss线程监听端口，worker线程负责数据读写
		ExecutorService boss = Executors.newCachedThreadPool();
		ExecutorService worker = Executors.newCachedThreadPool();
		
		//设置niosocket工厂
		bootstrap.setFactory(new NioServerSocketChannelFactory(boss, worker));
		
		//设置管道的工厂
		bootstrap.setPipelineFactory(() -> {
            ChannelPipeline pipeline = Channels.pipeline();
            pipeline.addLast("decoder", new MyDecoder());
            pipeline.addLast("handler1", new HelloHandler());
            return pipeline;
        });
		
		bootstrap.bind(new InetSocketAddress(10101));
		System.out.println("start!!!");
	}
}
