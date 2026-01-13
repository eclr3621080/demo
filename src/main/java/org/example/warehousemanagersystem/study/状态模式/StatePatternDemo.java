package org.example.warehousemanagersystem.study.状态模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-30
 * @Description: 状态模式允许对象在内部状态改变时改变其行为，使得对象在不同的状态下有不同的行为表现。通过将每个状态封装成独立的类，可以避免使用大量的条件语句来实现状态切换。
 * @Version: 1.0
 */


public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        //启动当前状态
        startState.doAction(context);
        System.out.println(context.getState().toString());
        StopState stopState = new StopState();
        //结束当前状态
        stopState.doAction(context);
        System.out.println(context.getState().toString());
    }
}
