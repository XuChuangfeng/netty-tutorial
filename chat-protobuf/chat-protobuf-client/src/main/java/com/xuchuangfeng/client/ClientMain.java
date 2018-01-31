package com.xuchuangfeng.client;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xuchuangfeng.client.swing.SwingClient;

/**
 * 启动函数
 *
 * @author XuChuangFeng
 */
public class ClientMain {
    
    @SuppressWarnings("resource")
    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        
        SwingClient swing = applicationContext.getBean(SwingClient.class);
        swing.setVisible(true);
    }
    
}
