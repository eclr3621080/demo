package org.example.warehousemanagersystem.study.适配器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class VlcPlayer implements AdvancedMediaPlayer{
    @Override
    public void playVlc(String fileName) {
        System.out.println("Playing vlc file.Name"+fileName);
    }

    @Override
    public void playMp4(String fileName) {

    }
}
