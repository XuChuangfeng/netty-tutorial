package com.xuchuangfeng.client.module.chat.handler;
import com.xuchuangfeng.common.core.annotion.SocketCommand;
import com.xuchuangfeng.common.core.annotion.SocketModule;
import com.xuchuangfeng.common.module.ModuleId;
import com.xuchuangfeng.common.module.chat.ChatCmd;
import com.xuchuangfeng.common.module.chat.response.ChatResponse;
/**
 * 聊天
 * @author XuChuangFeng
 *
 */
@SocketModule(module = ModuleId.CHAT)
public interface ChatHandler {
	
	/**
	 * 发送广播消息回包
	 * @param resultCode
	 * @param data {@link null}
	 * @return
	 */
	@SocketCommand(cmd = ChatCmd.PUBLIC_CHAT)
	public void publicChat(int resultCode, byte[] data);
	
	/**
	 * 发送私人消息回包
	 * @param resultCode
	 * @param data {@link null}
	 * @return
	 */
	@SocketCommand(cmd = ChatCmd.PRIVATE_CHAT)
	public void privateChat(int resultCode, byte[] data);
	
	/**
	 * 收到推送聊天信息
	 * @param resultCode
	 * @param data {@link ChatResponse}
	 * @return
	 */
	@SocketCommand(cmd = ChatCmd.PUSHCHAT)
	public void receieveMessage(int resultCode, byte[] data);
}
