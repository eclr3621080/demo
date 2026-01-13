package org.example.warehousemanagersystem.study.传输对象模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-06
 * @Description:
 * @Version: 1.0
 */


public class StudentBO {
    //列表是当作一个数据库
    List<StudentVO> students;

    public StudentBO() {
        students = new ArrayList<StudentVO>();
        StudentVO student1=new StudentVO("Robert",0);
        StudentVO john = new StudentVO("John", 1);
        students.add(student1);
        students.add(john);
    }

    public void deleteStuent(StudentVO student){
        students.remove(student);
        System.out.println("Student: Roll No "
                + student.getRollNo() +", deleted from database");
    }
    public List<StudentVO> getStudents() {
        return students;
    }
    public StudentVO getStudent(int rollNo) {
        return students.get(rollNo);
    }

    public void updateStudent(StudentVO student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No "
                + student.getRollNo() +", updated in the database");
    }

}
