package org.example.warehousemanagersystem.study.DI依赖注入;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-11-19
 * @Description:
 * @Version: 1.0
 */


public class Student {
    private Integer id;
    private String name;
    private Double score;
    public Student(Integer id, String name, Double score) {
        this.id = id;
        this.name = name;
        this.score = score;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }

}
