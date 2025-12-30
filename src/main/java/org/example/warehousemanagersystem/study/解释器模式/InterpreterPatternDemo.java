package org.example.warehousemanagersystem.study.解释器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */


public class InterpreterPatternDemo {
    public static Expression getMaleExpression(){
        Expression  robert = new TerminalExpression("Robert");
        Expression  john  = new TerminalExpression("John");
        return new OrExpression(robert,john);
    }

    public static Expression getMarrieWomanExpression(){
        TerminalExpression julie = new TerminalExpression("Julie");
        TerminalExpression married = new TerminalExpression("Married");
        return  new AndExpression(julie,married);
    }

    public static void main(String[] args) {
        Expression isMale  = getMaleExpression();
        Expression isMarriedWoman  = getMarrieWomanExpression();

        System.out.println("John is male? " + isMale.interpret("John"));
        System.out.println("Julie is a married women? "
                + isMarriedWoman.interpret("Married Julie"));
    }

}
