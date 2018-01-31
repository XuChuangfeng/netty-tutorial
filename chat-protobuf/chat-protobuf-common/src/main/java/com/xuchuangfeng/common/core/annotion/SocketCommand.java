/**
 * 
 */
package com.xuchuangfeng.common.core.annotion;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 请求命令
 * @author XuChuangFeng
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SocketCommand {
	
	/**
	 * 请求的命令号
	 * @return
	 */
	short cmd();

}
