package org.example.warehousemanagersystem.study.备忘录模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description: 在不破坏封装性的前提下，捕获一个对象的内部状态，并允许在对象之外保存和恢复这些状态。
 * @Version: 1.0
 */


public class Memento {
    private String state;
    public Memento(String state){
        this.state = state;
    }
    public String getState(){
        return state;
    }
}
