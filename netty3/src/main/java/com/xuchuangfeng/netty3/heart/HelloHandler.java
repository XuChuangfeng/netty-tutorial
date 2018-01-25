package com.xuchuangfeng.netty3.heart;

import org.jboss.netty.channel.*;
import org.jboss.netty.handler.timeout.IdleState;
import org.jboss.netty.handler.timeout.IdleStateEvent;

/**
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
			if(((IdleStateEvent)e).getState() == IdleState.ALL_IDLE){
				System.out.println("提玩家下线");
				//关闭会话,踢玩家下线
				ChannelFuture write = ctx.getChannel().write("time out, you will close");
				write.addListener(future -> ctx.getChannel().close());
			}
		} else {
			super.handleUpstream(ctx, e);
		}
	}
}
