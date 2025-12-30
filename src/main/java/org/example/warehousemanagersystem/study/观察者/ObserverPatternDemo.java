package org.example.warehousemanagersystem.study.观察者;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-29
 * @Description:
 * @Version: 1.0
 */


public class ObserverPatternDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        new HaxaObserver(subject);
        new OctalObserver(subject);
        new BinaryObserver(subject);
        System.out.println("First state change 15");
        subject.setState(15);
        System.out.println("Second state change 15");
        subject.setState(10);

    }
}
