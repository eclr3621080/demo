package org.example.warehousemanagersystem.study.适配器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:不同的音乐形式进来，能找到相应对的音乐格式进行播放
 * @Version: 1.0
 */


public class AudioPlayer implements MediaPlayer {
    MediaAdapter mediaAdapter;
    @Override
    public void play(String audioType, String fileName) {
        //播放mp3 音乐文件的内置支持
        if (audioType.equalsIgnoreCase("mp3")) {
            System.out.println("Playing mp3 file:"+fileName);
        }
        else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
            mediaAdapter = new MediaAdapter(audioType);
            mediaAdapter.play(audioType, fileName);
        }
        else {
            System.out.println("Invalid audio type");
        }
    }
}
