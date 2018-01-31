package com.xuchuangfeng.client;

import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelStateEvent;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.channel.SimpleChannelHandler;

import com.xuchuangfeng.client.scanner.Invoker;
import com.xuchuangfeng.client.scanner.InvokerHolder;
import com.xuchuangfeng.client.swing.SwingClient;
import com.xuchuangfeng.common.core.model.Response;

/**
 * @author XuChuangFeng
 */
public class ClientHandler extends SimpleChannelHandler {
    
    /**
     * 界面
     */
    private SwingClient swingClient;
    
    public ClientHandler(SwingClient swingClient) {
        this.swingClient = swingClient;
    }
    
    /**
     * 接收消息
     */
    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        
        Response response = (Response) e.getMessage();
        
        handlerResponse(response);
    }
    
    /**
     * 消息代理
     *
     * @param response
     */
    private void handlerResponse(Response response) {
        
        //获取命令执行器
        Invoker invoker = InvokerHolder.getInvoker(response.getModule(), response.getCmd());
        if (invoker != null) {
            try {
                invoker.invoke(response.getStateCode(), response.getData());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            //找不到执行器
            System.out.println(String.format("module:%s  cmd:%s 找不到命令执行器", response.getModule(), response.getCmd()));
        }
    }
    
    /**
     * 断开链接
     */
    @Override
    public void channelDisconnected(ChannelHandlerContext ctx, ChannelStateEvent e) throws Exception {
        swingClient.getTips().setText("与服务器断开连接~~~");
    }
}
