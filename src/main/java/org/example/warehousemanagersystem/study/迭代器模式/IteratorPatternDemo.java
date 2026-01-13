package org.example.warehousemanagersystem.study.迭代器模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-23
 * @Description: 就是自己建一个迭代器，自己遍历一边
 * @Version: 1.0
 */


public class IteratorPatternDemo {
    public static void main(String[] args) {

        NameRepository nameRepository = new NameRepository();
        for (Iterator iterator = nameRepository.getIterator(); iterator.hasNext(); ) {
            String  name =(String)  iterator.next();
            System.out.println(name);
        }
    }
}
