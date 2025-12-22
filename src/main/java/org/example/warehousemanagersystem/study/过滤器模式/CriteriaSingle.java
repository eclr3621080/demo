package org.example.warehousemanagersystem.study.过滤器模式;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-12-22
 * @Description:
 * @Version: 1.0
 */


public class CriteriaSingle implements Criteria{
    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        List<Person> singlePersons = new ArrayList<Person>();
        for (Person person : personList) {
            if(person.getMaritalStatus().equalsIgnoreCase("Single")){
                singlePersons.add(person);
            }
        }
        return singlePersons;
    }
}
