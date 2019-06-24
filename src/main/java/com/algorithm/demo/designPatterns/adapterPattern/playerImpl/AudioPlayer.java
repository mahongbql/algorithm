package com.algorithm.demo.designPatterns.adapterPattern.playerImpl;

import com.algorithm.demo.designPatterns.adapterPattern.MediaAdapter;
import com.algorithm.demo.designPatterns.adapterPattern.player.MediaPlayer;

/**
 * @author mahongbin
 * @date 2019/6/24 15:52
 * @Description
 */
public class AudioPlayer implements MediaPlayer {

    public static final String VLC = "vlc";
    public static final String MP4 = "mp4";
    public static final String MP3 = "mp3";

    MediaAdapter mediaAdapter;

    @Override
    public void play(String audioType, String fileName) {
        //播放 mp3 音乐文件的内置支持
        if(audioType.equalsIgnoreCase(MP3)){
            System.out.println("播放 mp3 文件，文件名: "+ fileName);
        }
        //mediaAdapter 提供了播放其他文件格式的支持
        else if(audioType.equalsIgnoreCase(VLC)
                || audioType.equalsIgnoreCase(MP4)){
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else{
            System.out.println("Invalid media. "+
                    audioType + " format not supported");
        }
    }
}
