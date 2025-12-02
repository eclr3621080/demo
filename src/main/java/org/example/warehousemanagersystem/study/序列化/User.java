package org.example.warehousemanagersystem.study.序列化;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-11-20
 * @Description:
 * @Version: 1.0
 */

@Data
public class User implements Serializable {
    //以在类内添加一行如下所示的代码，从而实现序列化版本兼容
    private static final long serialVersionUID = 1L;
    private transient  String id;
    private transient  String name;
    private int age;
}
