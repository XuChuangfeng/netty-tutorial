package com.xuchuangfeng.client.module.player.handler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xuchuangfeng.client.swing.ResultCodeTip;
import com.xuchuangfeng.client.swing.SwingClient;
import com.xuchuangfeng.common.core.model.ResultCode;
import com.xuchuangfeng.common.module.player.proto.PlayerModule;
import com.xuchuangfeng.common.module.player.proto.PlayerModule.PlayerResponse;
import com.google.protobuf.InvalidProtocolBufferException;

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
			try {
				//反序列化
				PlayerResponse playerResponse = PlayerModule.PlayerResponse.parseFrom(data);
				
				swingClient.setPlayerResponse(playerResponse);
				swingClient.getTips().setText("注册登录成功");
			} catch (InvalidProtocolBufferException e) {
				e.printStackTrace();
				swingClient.getTips().setText("反序列化异常");
			}
		}else{
			swingClient.getTips().setText(resultCodeTip.getTipContent(resultCode));
		}
	}

	@Override
	public void login(int resultCode, byte[] data) {
		if(resultCode == ResultCode.SUCCESS){
			try {
				//反序列化
				PlayerResponse playerResponse = PlayerModule.PlayerResponse.parseFrom(data);
				
				swingClient.setPlayerResponse(playerResponse);
				swingClient.getTips().setText("登录成功");
			} catch (InvalidProtocolBufferException e) {
				e.printStackTrace();
				swingClient.getTips().setText("反序列化异常");
			}
		}else{
			swingClient.getTips().setText(resultCodeTip.getTipContent(resultCode));
		}
	}
}
