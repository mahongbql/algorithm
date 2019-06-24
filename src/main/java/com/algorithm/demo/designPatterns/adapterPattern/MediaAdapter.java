package com.algorithm.demo.designPatterns.adapterPattern;

import com.algorithm.demo.designPatterns.adapterPattern.player.AdvancedMediaPlayer;
import com.algorithm.demo.designPatterns.adapterPattern.player.MediaPlayer;
import com.algorithm.demo.designPatterns.adapterPattern.playerImpl.Mp4Player;
import com.algorithm.demo.designPatterns.adapterPattern.playerImpl.VlcPlayer;

/**
 * @author mahongbin
 * @date 2019/6/24 15:47
 * @Description
 */
public class MediaAdapter implements MediaPlayer {

    public static final String VLC = "vlc";
    public static final String MP4 = "mp4";

    AdvancedMediaPlayer advancedMediaPlayer;

    public MediaAdapter(String audioType) {
        if (VLC.equals(audioType)) {
            advancedMediaPlayer = new VlcPlayer();
        } else if (MP4.equals(audioType)) {
            advancedMediaPlayer = new Mp4Player();
        }
    }

    @Override
    public void play(String audioType, String fileName) {
        if (VLC.equals(audioType)) {
            advancedMediaPlayer.playVlc(fileName);
        } else if (MP4.equals(audioType)) {
            advancedMediaPlayer.playMp4(fileName);
        }
    }
}
