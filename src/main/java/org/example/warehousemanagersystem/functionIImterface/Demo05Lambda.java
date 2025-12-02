package org.example.warehousemanagersystem.functionIImterface;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-01
 * @Description:如果一个方法的返回值类型是一个函数式接口，那么就可以直接返回一个lambda表达式。 假设需要一个方法来获取java.util.Comparator接口的对象作为排序器
 * @Version: 1.0
 */


public class Demo05Lambda {
    public static Comparator<String> getComparator(){
//        return new Comparator<String>(){
//            @Override
//            public int compare(String o1, String o2) {
//                return o1.length()-o2.length();
//            }
//        };
        return ((o1, o2) ->  o2.length()-o1.length());
    }

    public static void main(String[] args) {
        String[] arr={"a","bb","ccc"};
        System.out.println(Arrays.toString(arr));
        Arrays.sort(arr,getComparator());
        System.out.println(Arrays.toString(arr));
    }
}
