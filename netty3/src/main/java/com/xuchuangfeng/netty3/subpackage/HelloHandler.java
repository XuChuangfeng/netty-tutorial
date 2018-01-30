package com.xuchuangfeng.netty3.subpackage;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

/**
 * @author XuChuangFeng
 */
public class HelloHandler extends SimpleChannelHandler {

    private int count = 1;

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println(e.getMessage() + "  " + count);
        count++;
    }
}
