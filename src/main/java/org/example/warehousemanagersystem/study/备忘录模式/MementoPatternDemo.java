package org.example.warehousemanagersystem.study.备忘录模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description: 很简单
 * @Version: 1.0
 */


public class MementoPatternDemo {
    public static void main(String[] args) {
        //state实体类
        Originator originator = new Originator();
        //收集state
        CareTaker careTaker = new CareTaker();

        originator.setState("State #1");
        originator.setState("State #2");
        //存入的是"State #2"
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #3");
        careTaker.add(originator.saveStateToMemento());
        originator.setState("State #4");

        System.out.println("Current State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(0));
        System.out.println("First saved State: " + originator.getState());
        originator.getStateFromMemento(careTaker.get(1));
        System.out.println("Second saved State: " + originator.getState());
    }
}
