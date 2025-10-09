package org.example.warehousemanagersystem.common;

import org.example.warehousemanagersystem.service.user.service.UserService;

import java.io.Serializable;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-09-28
 * @Description:
 * @Version: 1.0
 */


public class RetStatus<T> implements Serializable {
    private static final long serialVersionUID = -4623179344362188723L;
    private String code;
    private String msg;
    private T data;

    public RetStatus() {
        this.code = "0000";
        this.msg = "success";
    }

    public RetStatus(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public RetStatus(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public void set(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public void set(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public String getcode() {
        return code;
    }

    public void setcode(String code) {
        this.code = code;
    }

    public String getmsg() {
        return msg;
    }

    public void setmsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
