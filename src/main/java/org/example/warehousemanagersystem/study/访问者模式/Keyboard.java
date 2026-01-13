package org.example.warehousemanagersystem.study.访问者模式;

import java.awt.event.KeyListener;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 创建扩展了上述类的实体类。
 * @Version: 1.0
 */


public class Keyboard   implements ComputerPart {
    @Override
    public void accept(ComputerPartVisitor computerPartVistor) {
        //输入当前环境，也就是KeyBoard
        computerPartVistor.visit(this);
    }
}
