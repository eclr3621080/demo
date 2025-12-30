package org.example.warehousemanagersystem.study.状态模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-30
 * @Description:
 * @Version: 1.0
 */


public class Context {
    private State state;

    public Context(){
        state=null;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
