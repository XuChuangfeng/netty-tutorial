package com.xuchuangfeng.netty5.heart;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * 定时清除无效的连接
 * @author XuChuangFeng
 */
public class ServerHandler extends SimpleChannelInboundHandler<String> {

    @Override
    protected void messageReceived(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(msg);
        ctx.channel().writeAndFlush("hi");
        ctx.writeAndFlush("hi");
    }

    /**
     * 接收事件
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(final ChannelHandlerContext ctx, Object evt) throws Exception {
        if (evt instanceof IdleStateEvent) {
            if (((IdleStateEvent) evt).state() == IdleState.ALL_IDLE) {
                System.out.println("十秒没有读写，关闭连接");
                //关闭会话,踢玩家下线
                ChannelFuture write = ctx.channel().write("time out, chanel will be closed soon!");
                write.addListener(future -> ctx.channel().close());
            } else if (((IdleStateEvent) evt).state() == IdleState.WRITER_IDLE) {
                System.out.println("五秒没有写");
            } else if (((IdleStateEvent) evt).state() == IdleState.READER_IDLE) {
                System.out.println("五秒没有读");
            }
        } else {
            super.userEventTriggered(ctx, evt);
        }
    }

    /**
     * 新客户端接入
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelActive");
    }

    /**
     * 客户端断开
     */
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("channelInactive");
    }

    /**
     * 异常
     */
    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
    }

}
