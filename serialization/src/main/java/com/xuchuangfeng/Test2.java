package com.xuchuangfeng;

import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * 使用java nio包的ByteBuffer进行序列化，无法动态扩容，而且占用较多字节数
 *
 * @author XuChuangFeng
 */
public class Test2 {

	public static void main(String[] args) {
		int id = 101;
		int age = 21;
		
		ByteBuffer buffer = ByteBuffer.allocate(8);
		buffer.putInt(id);
		buffer.putInt(age);
		byte[] array = buffer.array();
		System.out.println(Arrays.toString(buffer.array()));
		
		//====================================================
		
		ByteBuffer buffer2 = ByteBuffer.wrap(array);
		System.out.println("id:"+buffer2.getInt());
		System.out.println("age:"+buffer2.getInt());
	}

}
