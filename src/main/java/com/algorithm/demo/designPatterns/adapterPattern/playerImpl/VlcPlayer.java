package com.algorithm.demo.designPatterns.adapterPattern.playerImpl;

import com.algorithm.demo.designPatterns.adapterPattern.player.AdvancedMediaPlayer;

/**
 * @author mahongbin
 * @date 2019/6/24 15:41
 * @Description
 */
public class VlcPlayer implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {
        System.out.println("播放 vlc 文件，文件名：" + fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
