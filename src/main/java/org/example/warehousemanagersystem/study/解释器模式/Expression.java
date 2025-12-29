package org.example.warehousemanagersystem.study.解释器模式;

/**
 * 定义一种语言的文法表示，并创建一个解释器，该解释器能够解释该语言中的句子。。
 */
public interface Expression {
    public boolean interpret(String context);
}
