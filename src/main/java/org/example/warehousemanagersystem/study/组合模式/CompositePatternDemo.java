package org.example.warehousemanagersystem.study.组合模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description: 将对象组合成树形结构以表示"部分-整体"的层次结构。组合模式使得用户对单个对象和组合对象的使用具有一致性。
 * @Version: 1.0
 */


public class CompositePatternDemo {
    public static void main(String[] args) {
        Employee CEO=new Employee("John","CEO",3000000);
        Employee headSales = new Employee("Robert","Head Sales", 20000);

        Employee headMarketing = new Employee("Michel","Head Marketing", 20000);

        Employee clerk1 = new Employee("Laura","Marketing", 10000);
        Employee clerk2 = new Employee("Bob","Marketing", 10000);

        Employee salesExecutive1 = new Employee("Richard","Sales", 10000);
        Employee salesExecutive2 = new Employee("Rob","Sales", 10000);

        CEO.add(headSales);
        CEO.add(headMarketing);

        headSales.add(salesExecutive1);
        headSales.add(salesExecutive2);

        headMarketing.add(clerk1);
        headMarketing.add(clerk2);
        //打印该组织的所有员工
        System.out.println(CEO);

        System.out.println("-------------");



        for (Employee headEmployee : CEO.getSubordinates()) {
            System.out.println(headEmployee);
            for (Employee employee : headEmployee.getSubordinates()) {
                System.out.println(employee);
            }
            System.out.println("----------***********");
        }

    }
}
