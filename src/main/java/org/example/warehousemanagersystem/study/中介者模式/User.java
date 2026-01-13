package org.example.warehousemanagersystem.study.中介者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */

//实体类
public class User {
    private String name;

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public User(String name){
        this.name = name;
    }
    public void sendMessage(String message){
        ChatRoom.showMessage(this, message);
    }
}
