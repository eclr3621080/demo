package org.example.warehousemanagersystem.study.传输对象模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2026-01-06
 * @Description:
 * @Version: 1.0
 */


public class TransferObjectPatternDemo {
    public static void main(String[] args) {
        StudentBO studentBusinessObject  = new StudentBO();
        //输出所有的学生
        for (StudentVO student : studentBusinessObject.getStudents()) {
            System.out.println("Student: [RollNo : "
                    +student.getRollNo()+", Name : "+student.getName()+" ]");
        }

        //更新学生
        StudentVO studentVO = studentBusinessObject.getStudents().get(0);
        studentVO.setName("sq");
        studentBusinessObject.updateStudent(studentVO);

        //获取学生
        studentBusinessObject.getStudent(0);
        System.out.println("Student: [RollNo : "
                +studentVO.getRollNo()+", Name : "+studentVO.getName()+" ]");
    }
}
