package com.xuchuangfeng.client.module.chat.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xuchuangfeng.client.swing.ResultCodeTip;
import com.xuchuangfeng.client.swing.SwingClient;
import com.xuchuangfeng.common.core.model.ResultCode;
import com.xuchuangfeng.common.module.chat.proto.ChatModule;
import com.xuchuangfeng.common.module.chat.proto.ChatModule.ChatResponse;
import com.xuchuangfeng.common.module.chat.proto.ChatModule.ChatType;
import com.google.protobuf.InvalidProtocolBufferException;

/**
 * @author XuChuangFeng
 */
@Component
public class ChatHandlerImpl implements ChatHandler{
	
	@Autowired
	private SwingClient swingClient;
	@Autowired
	private ResultCodeTip resultCodeTip;

	@Override
	public void publicChat(int resultCode, byte[] data) {
		if(resultCode == ResultCode.SUCCESS){
			swingClient.getTips().setText("发送成功");
		}else{
			swingClient.getTips().setText(resultCodeTip.getTipContent(resultCode));
		}
	}

	@Override
	public void privateChat(int resultCode, byte[] data) {
		if(resultCode == ResultCode.SUCCESS){
			swingClient.getTips().setText("发送成功");
		}else{
			swingClient.getTips().setText(resultCodeTip.getTipContent(resultCode));
		}
	}

	@Override
	public void receieveMessage(int resultCode, byte[] data) {
		
		try {
			ChatResponse chatResponse = ChatModule.ChatResponse.parseFrom(data);
			
			if(chatResponse.getChatType() == ChatType.PUBLIC){
				StringBuilder builder = new StringBuilder();
				builder.append(chatResponse.getSendPlayerName());
				builder.append("[");
				builder.append(chatResponse.getSendPlayerId());
				builder.append("]");
				builder.append(" 说:\n\t");
				builder.append(chatResponse.getMessage());
				builder.append("\n\n");
				
				swingClient.getChatContext().append(builder.toString());
			}else if(chatResponse.getChatType()==ChatType.PRIVATE){
				StringBuilder builder = new StringBuilder();
				
				if(swingClient.getPlayerResponse().getPlayerId() == chatResponse.getSendPlayerId()){
					builder.append("您悄悄对 ");
					builder.append("[");
					builder.append(chatResponse.getTargetPlayerName());
					builder.append("]");
					builder.append(" 说:\n\t");
					builder.append(chatResponse.getMessage());
					builder.append("\n\n");
				}else{
					builder.append(chatResponse.getSendPlayerName());
					builder.append("[");
					builder.append(chatResponse.getSendPlayerId());
					builder.append("]");
					builder.append(" 悄悄对你说:\n\t");
					builder.append(chatResponse.getMessage());
					builder.append("\n\n");
				}
				
				swingClient.getChatContext().append(builder.toString());
			}
		} catch (InvalidProtocolBufferException e) {
			e.printStackTrace();
			swingClient.getTips().setText("反序列化异常");
		}
	}
}
