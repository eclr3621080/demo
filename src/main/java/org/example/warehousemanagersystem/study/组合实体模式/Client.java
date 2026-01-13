package org.example.warehousemanagersystem.study.组合实体模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-31
 * @Description:
 * @Version: 1.0
 */


public class Client {
    //使用组合数组对象
    private CompositeEntity  compositeEntity=new CompositeEntity();
    //把组合字符串数组轮流输出
   public void printData(){
       for (int i=0;i<compositeEntity.getData().length;i++){
           System.out.println("Data:"+compositeEntity.getData()[i]);
       }
   }
    //往组合字符串数组塞入数据
   public void setData(String data1,String data2){
       compositeEntity.setData(data1,data2);
   }
}
