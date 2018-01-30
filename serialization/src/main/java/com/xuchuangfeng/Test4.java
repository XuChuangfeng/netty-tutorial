package com.xuchuangfeng;

import com.xuchuangfeng.core.Player;

import java.util.Arrays;

/**
 * 使用自定义的序列化抽象类，可以使得占用的字节数降低很多，并且动态扩容
 *
 * @author XuChuangFeng
 */
public class Test4 {

    public static void main(String[] args) {

        Player player = new Player();
        player.setPlayerId(10001);
        player.setAge(22);
        player.getSkills().add(101);
        player.getResource().setGold(99999);

        byte[] bytes = player.getBytes();

        System.out.println(Arrays.toString(bytes));

        //==============================================

        Player player2 = new Player();
        player2.readFromBytes(bytes);
        System.out.println(player2.getPlayerId() + "   " + player2.getAge() + "     " + Arrays.toString(player2.getSkills().toArray()) + "   " + player2.getResource().getGold());
    }

}
