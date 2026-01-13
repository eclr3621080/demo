package org.example.warehousemanagersystem.study.数据访问对象模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 实体类 创建数值对象。
 * @Version: 1.0
 */


public class Student {
    private String name;
    private int rollNo;

    public Student(String name, int rollNo) {
        this.name = name;
        this.rollNo = rollNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }
}
