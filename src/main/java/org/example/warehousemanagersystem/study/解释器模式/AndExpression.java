package org.example.warehousemanagersystem.study.解释器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */


public class AndExpression implements Expression {
    private Expression expr1=null;
    private Expression expr2=null;
    public AndExpression(Expression expr1, Expression expr2) {
        this.expr1=expr1;
        this.expr2=expr2;
    }

    @Override
    public boolean interpret(String context) {
        return expr1.interpret(context) && expr2.interpret(context);
    }
}
