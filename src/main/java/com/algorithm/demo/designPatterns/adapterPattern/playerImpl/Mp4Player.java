package com.algorithm.demo.designPatterns.adapterPattern.playerImpl;

import com.algorithm.demo.designPatterns.adapterPattern.player.AdvancedMediaPlayer;

/**
 * @author mahongbin
 * @date 2019/6/24 15:45
 * @Description
 */
public class Mp4Player implements AdvancedMediaPlayer {
    @Override
    public void playVlc(String fileName) {

    }

    @Override
    public void playMp4(String fileName) {
        System.out.println("播放 mp4 文件，文件名: "+ fileName);
    }
}
