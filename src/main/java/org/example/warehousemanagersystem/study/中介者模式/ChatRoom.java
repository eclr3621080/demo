package org.example.warehousemanagersystem.study.中介者模式;

import java.util.Date;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description:
 * @Version: 1.0
 */


public class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(new Date().toString()
                + " [" + user.getName() +"] : " + message);
    }
}
