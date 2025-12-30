package org.example.warehousemanagersystem.study.观察者;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-29
 * @Description:
 * @Version: 1.0
 */


public class HaxaObserver extends Observer {
    public HaxaObserver(Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println("HaxaObserver update"+Integer.toBinaryString(subject.getState()));
    }
}
