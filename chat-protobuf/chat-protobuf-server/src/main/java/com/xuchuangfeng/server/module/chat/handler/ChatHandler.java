package com.xuchuangfeng.server.module.chat.handler;
import com.xuchuangfeng.common.core.annotion.SocketCommand;
import com.xuchuangfeng.common.core.annotion.SocketModule;
import com.xuchuangfeng.common.core.model.Result;
import com.xuchuangfeng.common.module.ModuleId;
import com.xuchuangfeng.common.module.chat.ChatCmd;
import com.xuchuangfeng.common.module.chat.proto.ChatModule.PrivateChatRequest;
import com.xuchuangfeng.common.module.chat.proto.ChatModule.PublicChatRequest;
/**
 * 聊天
 * @author XuChuangFeng
 *
 */
@SocketModule(module = ModuleId.CHAT)
public interface ChatHandler {
	
	
	/**
	 * 广播消息
	 * @param playerId
	 * @param data {@link PublicChatRequest}
	 * @return
	 */
	@SocketCommand(cmd = ChatCmd.PUBLIC_CHAT)
	public Result<?> publicChat(long playerId, byte[] data);
	
	
	
	/**
	 * 私人消息
	 * @param playerId
	 * @param data {@link PrivateChatRequest}
	 * @return
	 */
	@SocketCommand(cmd = ChatCmd.PRIVATE_CHAT)
	public Result<?> privateChat(long playerId, byte[] data);
}
