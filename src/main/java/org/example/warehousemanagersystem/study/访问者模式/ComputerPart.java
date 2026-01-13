package org.example.warehousemanagersystem.study.访问者模式;

/**
 * 定义一个表示元素的接口。
 */
public interface ComputerPart {
    public void accept(ComputerPartVisitor computerPartVistor);
}
