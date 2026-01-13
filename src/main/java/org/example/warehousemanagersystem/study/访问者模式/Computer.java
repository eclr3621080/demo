package org.example.warehousemanagersystem.study.访问者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:  把所有的实现类全部初始化
 * @Version: 1.0
 */


public class Computer implements ComputerPart{


    ComputerPart[] parts;

    public Computer(){
        parts = new ComputerPart[] {new Mouse(), new Keyboard(), new Monitor()};
    }

    //把所有的实现类全部输出
    @Override
    public void accept(ComputerPartVisitor computerPartVisitor) {
        for (int i = 0; i < parts.length; i++) {
            parts[i].accept(computerPartVisitor);
        }
        computerPartVisitor.visit(this);
    }
}
