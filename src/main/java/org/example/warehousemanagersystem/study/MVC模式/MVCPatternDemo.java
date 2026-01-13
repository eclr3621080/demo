package org.example.warehousemanagersystem.study.MVC模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 将应用程序分为三个核心组件：模型（Model）、视图（View）和控制器（Controller），以实现关注点分离
 * @Version: 1.0
 */


public class MVCPatternDemo {
    public static void main(String[] args) {
        //从数据库获取学生记录
        Student model  =retrieveStudentFromDatabase();
        //创建一个视图：把学生详细信息输出到控制台
        StudentView view = new StudentView();
        //塞入数据与试图
        StudentController controller = new StudentController(model, view);
        //调用控制层的输出数据
        controller.updateView();
        //更新容器的名字数据
        controller.setStudentName("John");
        //再去输出数据
        controller.updateView();
    }
    //塞入数据，返回实体类
    private static Student retrieveStudentFromDatabase(){
        Student student = new Student();
        student.setRollNo("1234");
        student.setName("shenqi");
        return student;
    }
}
