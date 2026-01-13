package org.example.warehousemanagersystem.study.状态模式;



/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-30
 * @Description: 开始执行
 * @Version: 1.0
 */


public class StartState implements State {
    //实现方法
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
        //相当于塞入当前开始的环境
       context.setState(this);
    }
    //返回
    public String toString(){
        return "Start State";
    }
}
