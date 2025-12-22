package org.example.warehousemanagersystem.study.过滤器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class CriteriaFemale implements Criteria {
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : personList) {
            if (person.getGender().equals("Female")) femalePersons.add(person);
        }
        return femalePersons;
    }
}
