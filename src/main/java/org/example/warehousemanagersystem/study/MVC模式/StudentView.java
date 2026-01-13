package org.example.warehousemanagersystem.study.MVC模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 创建视图。
 * @Version: 1.0
 */


public class StudentView {
    public void printStudentDetails(String studentName,String studentRollNo){
        System.out.println("Student:");
        System.out.println("Name: "+studentName);
        System.out.println("Roll No: "+studentRollNo);
    }
}
