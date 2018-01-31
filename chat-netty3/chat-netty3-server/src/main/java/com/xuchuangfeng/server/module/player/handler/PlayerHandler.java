package com.xuchuangfeng.server.module.player.handler;

import com.xuchuangfeng.common.core.annotion.SocketCommand;
import com.xuchuangfeng.common.core.annotion.SocketModule;
import com.xuchuangfeng.common.core.model.Result;
import com.xuchuangfeng.common.core.session.Session;
import com.xuchuangfeng.common.module.ModuleId;
import com.xuchuangfeng.common.module.player.PlayerCmd;
import com.xuchuangfeng.common.module.player.request.LoginRequest;
import com.xuchuangfeng.common.module.player.request.RegisterRequest;
import com.xuchuangfeng.common.module.player.response.PlayerResponse;
/**
 * 玩家模块
 * @author XuChuangFeng
 *
 */
@SocketModule(module = ModuleId.PLAYER)
public interface PlayerHandler {
	
	
	/**
	 * 创建并登录帐号
	 * @param session
	 * @param data {@link RegisterRequest}
	 * @return
	 */
	@SocketCommand(cmd = PlayerCmd.REGISTER_AND_LOGIN)
	public Result<PlayerResponse> registerAndLogin(Session session, byte[] data);
	

	/**
	 * 登录帐号
	 * @param session
	 * @param data {@link LoginRequest}
	 * @return
	 */
	@SocketCommand(cmd = PlayerCmd.LOGIN)
	public Result<PlayerResponse> login(Session session, byte[] data);

}
