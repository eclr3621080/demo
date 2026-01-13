package org.example.warehousemanagersystem.study.前端控制器;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description: 使用一个中心控制器（或处理器）来转发客户端请求到适当的处理程序。
 * @Version: 1.0
 */


public class FrontControllerPatternDemo {
    public static void main(String[] args) {
        FrontController frontController = new FrontController();

        frontController.dispatchRequest("HOME");
        frontController.dispatchRequest("STUDENT");
    }
}
