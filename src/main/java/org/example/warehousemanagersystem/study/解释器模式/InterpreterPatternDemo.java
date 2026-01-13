package org.example.warehousemanagersystem.study.解释器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */


public class InterpreterPatternDemo {
    public static Expression getMaleExpression(){
        //塞入数据，用的是TerminalExpression类，所以回去去调TerminalExpression的实现方法
        Expression  robert = new TerminalExpression("Robert");
        Expression  john  = new TerminalExpression("John");
        return new OrExpression(robert,john);
    }

    public static Expression getMarrieWomanExpression(){
        //塞入数据
        TerminalExpression julie = new TerminalExpression("Julie");
        TerminalExpression married = new TerminalExpression("Married");
        return  new AndExpression(julie,married);
    }

    public static void main(String[] args) {
        Expression isMale  = getMaleExpression();
        isMale.interpret("Robert");
        Expression isMarriedWoman  = getMarrieWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? "
                + isMarriedWoman.interpret("Married Julie"));
    }

}
