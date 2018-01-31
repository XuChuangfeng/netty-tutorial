package com.xuchuangfeng.server.module.player.service;

import com.xuchuangfeng.common.core.session.Session;
import com.xuchuangfeng.common.module.player.response.PlayerResponse;
/**
 * 玩家服务
 * @author XuChuangFeng
 *
 */
public interface PlayerService {
	
	
	/**
	 * 登录注册用户
	 * @param playerName
	 * @param passward
	 * @return
	 */
	public PlayerResponse registerAndLogin(Session session, String playerName, String passward);
	
	
	/**
	 * 登录
	 * @param playerName
	 * @param passward
	 * @return
	 */
	public PlayerResponse login(Session session, String playerName, String passward);

}
