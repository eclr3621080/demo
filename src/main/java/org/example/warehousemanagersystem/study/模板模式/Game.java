package org.example.warehousemanagersystem.study.模板模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 创建一个抽象类，它的模板方法被设置为 final。
 * @Version: 1.0
 */


public abstract class Game {
    abstract void initialize();
    abstract void startPlay();
    abstract void stopPlay();
    //模板
    public final void play(){
        //初始化游戏
        initialize();
        //开始游戏
        startPlay();
        //结束游戏
        stopPlay();
    }
}
