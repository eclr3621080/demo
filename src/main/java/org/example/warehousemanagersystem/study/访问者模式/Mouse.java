package org.example.warehousemanagersystem.study.访问者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class Mouse implements ComputerPart{
    @Override
    public void accept(ComputerPartVisitor computerPartVistor) {
        //输入当前环境，也就是Mouse
        computerPartVistor.visit(this);
    }
}
