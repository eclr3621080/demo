package org.example.warehousemanagersystem.study.观察者;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-29
 * @Description:
 * @Version: 1.0
 */


public class BinaryObserver extends   Observer {
    public BinaryObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("BinaryObserver update"+Integer.toBinaryString(subject.getState()));
    }
}
