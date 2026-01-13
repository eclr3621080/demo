package org.example.warehousemanagersystem.study.数据访问对象模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class DaoPatternDemo {
    public static void main(String[] args) {
        //创建学生类
        StudentDao studentDao = new StudentDaoImpl();
        //输出所有学生数据
        for (Student student : studentDao.getAllStudents()) {
            System.out.println("Student: [RollNo : "
                    +student.getRollNo()+", Name : "+student.getName()+" ]");
        }
        //获取第一个
        Student student=studentDao.getAllStudents().get(0);
        student.setName("Michael");
        //修改第一个值数据
        studentDao.updateStudent(student);

        studentDao.getStudent(0);
        System.out.println("Student: [RollNo : "
                +student.getRollNo()+", Name : "+student.getName()+" ]");
    }
}
