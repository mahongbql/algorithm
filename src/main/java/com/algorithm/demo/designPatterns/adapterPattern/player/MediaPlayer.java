package com.algorithm.demo.designPatterns.adapterPattern.player;

/**
 * @author mahongbin
 * @date 2019/6/24 15:33
 * @Description 只能播放mp3的接口
 */
public interface MediaPlayer {

    /**
     * audioType 是为了识别可以播放哪种音乐格式
     * @param audioType
     * @param fileName
     */
    void play(String audioType, String fileName);
}
