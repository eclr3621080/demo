package org.example.warehousemanagersystem.study.数据访问对象模式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class StudentDaoImpl implements StudentDao {
    //创建一个数组
    List<Student> students;
    //往数组中塞入数据
    public StudentDaoImpl() {
        students= new ArrayList<Student>();
        Student student1 = new Student("Robert",0);
        Student student2 = new Student("John",1);
        students.add(student1);
        students.add(student2);
    }
    //返回学生数组
    @Override
    public List<Student> getAllStudents() {
        return students;
    }
    //获取某个位置的学生数据
    @Override
    public Student getStudent(int rollNo) {
        return students.get(rollNo);
    }
    //更新某个位置的数据
    @Override
    public void  updateStudent(Student student) {
        students.get(student.getRollNo()).setName(student.getName());
        System.out.println("Student: Roll No " + student.getRollNo()
                +", updated in the database");
    }
    //删掉某个位置的数据
    @Override
    public void deleteStudent(Student student) {
        students.remove(student.getRollNo());
        System.out.println("Student: Roll No " + student.getRollNo()
                +", deleted from database");
    }
}
