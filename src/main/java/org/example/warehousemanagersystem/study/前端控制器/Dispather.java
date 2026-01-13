package org.example.warehousemanagersystem.study.前端控制器;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 创建调度器 Dispatcher
 * @Version: 1.0
 */


public class Dispather {

    private StudentView studentView;
    private Homeview homeView;
    //创建试图
    public Dispather(){
        studentView = new StudentView();
        homeView = new Homeview();
    }
    //根据输入的值，去输出相应的试图
    public void dispatch(String request){
        if (request.equalsIgnoreCase("STUDENT")){
            studentView.show();
        }else {
            homeView.show();
        }
    }
}
