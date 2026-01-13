package org.example.warehousemanagersystem.study.访问者模式;

import org.example.warehousemanagersystem.study.单例工程模式.SingleObject;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 定义一个表示访问者的接口。
 * @Version: 1.0
 */


public interface ComputerPartVisitor {
    public void visit(Computer computer);
    public void visit(Mouse mouse);
    public void visit(Keyboard keyboard);
    public void visit(Monitor monitor);


}
