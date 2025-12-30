package org.example.warehousemanagersystem.study.观察者;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-29
 * @Description: 创建了对象间的一种一对多的依赖关系，当一个对象状态改变时，所有依赖于它的对象都会得到通知并自动更新。。
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
