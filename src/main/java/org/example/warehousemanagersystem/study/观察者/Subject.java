package org.example.warehousemanagersystem.study.观察者;

import java.util.ArrayList;
import java.util.List;



/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-29
 * @Description:
 * @Version: 1.0
 */


public class Subject {
    private List<Observer> observers=new ArrayList<Observer>();
    private int state;
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        notifyAllObservers();
    }
    //往数组里面加
    public void attach(Observer observer){
        observers.add(observer);
    }

    public void notifyAllObservers(){
        for(Observer observer:observers){
            observer.update();
        }
    }
}
