package com.xuchuangfeng.client.module.player.handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xuchuangfeng.client.swing.ResultCodeTip;
import com.xuchuangfeng.client.swing.SwingClient;
import com.xuchuangfeng.common.core.model.ResultCode;
import com.xuchuangfeng.common.module.player.response.PlayerResponse;

/**
 * @author XuChuangFeng
 */
@Component
public class PlayerHandlerImpl implements PlayerHandler{
	
	@Autowired
	private SwingClient swingClient;
	@Autowired
	private ResultCodeTip resultCodeTip;

	@Override
	public void registerAndLogin(int resultCode, byte[] data) {
		if(resultCode == ResultCode.SUCCESS){
			PlayerResponse playerResponse = new PlayerResponse();
			playerResponse.readFromBytes(data);
			
			swingClient.setPlayerResponse(playerResponse);
			swingClient.getTips().setText("注册登录成功");
		}else{
			swingClient.getTips().setText(resultCodeTip.getTipContent(resultCode));
		}
	}

	@Override
	public void login(int resultCode, byte[] data) {
		if(resultCode == ResultCode.SUCCESS){
			PlayerResponse playerResponse = new PlayerResponse();
			playerResponse.readFromBytes(data);
			
			swingClient.setPlayerResponse(playerResponse);
			swingClient.getTips().setText("登录成功");
		}else{
			swingClient.getTips().setText(resultCodeTip.getTipContent(resultCode));
		}
	}
}
