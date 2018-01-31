package com.xuchuangfeng.client.swing;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * @author XuChuangFeng
 */
@Component
public class ResultCodeTip {
	
	private Properties properties = new Properties();
	
	@PostConstruct
	public void init() throws IOException{
		InputStream in = getClass().getResourceAsStream("/code.properties");
		BufferedReader bf = new BufferedReader(new InputStreamReader(in));  
		properties.load(bf);
	}
	
	/**
	 * 获取内容提示
	 * @param code
	 * @return
	 */
	public String getTipContent(int code){
		Object object = properties.get(code+"");
		if(object == null){
			return "错误码:" + code;
		}
		return object.toString();
	}

}
