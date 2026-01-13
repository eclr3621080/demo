package org.example.warehousemanagersystem.study.前端控制器;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class FrontController {
    private  Dispather dispather;
    //创建一个调度器
    public FrontController() {
        dispather=new Dispather();
    }
    //判断是否成功
    private boolean isAuthenticUser(){
        System.out.println("User is authenticated successfully.");
        return true;
    }
    //输出
    private void trackRequest(String request){
        System.out.println("Page requested: " + request);
    }

    public void dispatchRequest(String request){
        //输出数据
        trackRequest(request);
        //返回成功的时候，去分流
        if (isAuthenticUser()){
            dispather.dispatch(request);
        }
    }

}
