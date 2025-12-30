package org.example.warehousemanagersystem.study.备忘录模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */


public class CareTaker {
    private List<Memento> mementosList=new ArrayList<Memento>();

    public void add(Memento state){
        mementosList.add(state);
    }

    public Memento get(int index){
        return mementosList.get(index);
    }
}
