package org.example.warehousemanagersystem.study.状态模式;



/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-30
 * @Description:
 * @Version: 1.0
 */


public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in stop state");
        context.setState(this);
    }

    @Override
    public String toString() {
        return "StopState{}";
    }
}
