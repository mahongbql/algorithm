package com.algorithm.demo.designPatterns.adapterPattern.player;

/**
 * @author mahongbin
 * @date 2019/6/24 15:35
 * @Description 播放MP4和vlc格式的
 */
public interface AdvancedMediaPlayer {
    void playVlc(String fileName);
    void playMp4(String fileName);
}
