package org.example.warehousemanagersystem.study.序列化;

import java.io.*;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-11-20
 * @Description:
 * @Version: 1.0
 */


public class Serializable {
    public static void main(String[] args) {
        User user = new User();
        user.setId("1");
        user.setName("sq");
        user.setAge(18);
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("user.ser"))){
            oos.writeObject(user);
            System.out.println("序列化成功！对象一些如user.ser文件");

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
//        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("user.ser"))){
//            // 核心操作：反序列化，返回值是 Object，需要强转
//            User deserializedUser = (User) ois.readObject();
//            System.out.println("反序列化成功！还原的对象：" + deserializedUser);
//            System.out.println("还原的用户名：" + deserializedUser.getName());
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
    }
}
