package com.xuchuangfeng.proto;

import com.xuchuangfeng.proto.PlayerModule.PBPlayer;
import com.xuchuangfeng.proto.PlayerModule.PBPlayer.Builder;

import java.util.Arrays;

/**
 * protocol buff是谷歌推出的一种序列化协议
 * Java序列化协议也是一种协议，占用字节数是protocol buff的十几二十倍
 * 两者的目的是，将对象序列化成字节数组，或者说是二进制数据
 * protocol buff占用很少的字节数，java序列化包含太多的类信息，字段信息等等
 * @author XuChuangFeng
 */
public class ProtoBuf2Bytes {

    public static void main(String[] args) throws Exception {
        byte[] bytes = toBytes();
        toPlayer(bytes);
    }

    /**
     * 序列化
     */
    public static byte[] toBytes() {
        //获取一个PBPlayer的构造器
        Builder builder = PlayerModule.PBPlayer.newBuilder();
        //设置数据
        builder.setPlayerId(101).setAge(20).setName("peter").addSkills(1001);
        //构造出对象
        PBPlayer player = builder.build();
        //序列化成字节数组
        byte[] byteArray = player.toByteArray();

        System.out.println(Arrays.toString(byteArray));

        return byteArray;
    }

    /**
     * 反序列化
     *
     * @param bs
     * @throws Exception
     */
    public static void toPlayer(byte[] bs) throws Exception {

        PBPlayer player = PlayerModule.PBPlayer.parseFrom(bs);

        System.out.println("playerId:" + player.getPlayerId());
        System.out.println("age:" + player.getAge());
        System.out.println("name:" + player.getName());
        System.out.println("skills:" + (Arrays.toString(player.getSkillsList().toArray())));
    }
}
