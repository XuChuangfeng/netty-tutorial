package com.xuchuangfeng.client.module.player.handler;
import com.xuchuangfeng.common.core.annotion.SocketCommand;
import com.xuchuangfeng.common.core.annotion.SocketModule;
import com.xuchuangfeng.common.module.ModuleId;
import com.xuchuangfeng.common.module.player.PlayerCmd;

/**
 * @author XuChuangFeng
 */
@SocketModule(module = ModuleId.PLAYER)
public interface PlayerHandler {
	
	
	/**
	 * 创建并登录帐号
	 * @param resultCode
	 * @param data {@link null}
	 */
	@SocketCommand(cmd = PlayerCmd.REGISTER_AND_LOGIN)
	public void registerAndLogin(int resultCode, byte[] data);
	

	/**
	 * 创建并登录帐号
	 * @param resultCode
	 * @param data {@link null}
	 */
	@SocketCommand(cmd = PlayerCmd.LOGIN)
	public void login(int resultCode, byte[] data);

}
