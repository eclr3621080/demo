package org.example.warehousemanagersystem.study.状态模式;



/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-30
 * @Description:
 * @Version: 1.0
 */


public class StopState implements State {
    //实现数据，塞入环境
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        //相当于塞入当前开始的环境
        context.setState(this);
    }
    //停止数据
    @Override
    public String toString() {
        return "StopState{}";
    }
}
