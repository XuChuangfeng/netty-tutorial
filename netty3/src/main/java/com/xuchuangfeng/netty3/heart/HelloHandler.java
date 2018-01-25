package com.xuchuangfeng.netty3.heart;

import org.jboss.netty.channel.*;
import org.jboss.netty.handler.timeout.IdleState;
import org.jboss.netty.handler.timeout.IdleStateEvent;

/**
 * 定时清除无效的连接
 * @author XuChuangFeng
 */
public class HelloHandler extends SimpleChannelHandler {

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        System.out.println(e.getMessage());
    }

    @Override
    public void handleUpstream(final ChannelHandlerContext ctx, ChannelEvent e) throws Exception {
        if (e instanceof IdleStateEvent) {
            if (((IdleStateEvent) e).getState() == IdleState.ALL_IDLE) {
                System.out.println("十秒没有读写，关闭连接");
                //关闭会话,踢玩家下线
                ChannelFuture write = ctx.getChannel().write("time out, chanel will be closed soon!");
                write.addListener(future -> ctx.getChannel().close());
            } else if (((IdleStateEvent) e).getState() == IdleState.WRITER_IDLE) {
                System.out.println("五秒没有写");
            } else if (((IdleStateEvent) e).getState() == IdleState.READER_IDLE) {
                System.out.println("五秒没有读");
            }
        } else {
            super.handleUpstream(ctx, e);
        }
    }
}
