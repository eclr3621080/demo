package org.example.warehousemanagersystem.study.建造者模式;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:BuiderPatternDemo 使用 MealBuilder 来演示建造者模式（Builder Pattern）。
 * @Version: 1.0
 */


public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal is "+vegMeal);
        //用来展示刚刚塞入的数据
        vegMeal.showItems();
        System.out.println("Total Cost:"+vegMeal.getCost());



        Meal vegMeal1 = mealBuilder.prepareNonVegMeal();
        System.out.println("NonVeg Meal is "+vegMeal1);
        vegMeal1.showItems();
        System.out.println("Total Cost:"+vegMeal1.getCost());
    }
}
