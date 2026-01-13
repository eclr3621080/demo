package org.example.warehousemanagersystem.study.传输对象模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-06
 * @Description:
 * @Version: 1.0
 */


public class StudentVO {
    private String name;
    private int rollNo;

    public StudentVO(String name, int rollNo) {
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
