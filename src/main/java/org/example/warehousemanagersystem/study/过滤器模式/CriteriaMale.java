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


public class CriteriaMale implements Criteria {
    @Override
    public List<Person> meetCriteria(List<Person> personList) {
        //过滤男生
        List<Person> malePersons  = new ArrayList<Person>();
        for (Person person : personList) {
            if (person.getGender().equalsIgnoreCase("Male")){
                malePersons .add(person);
            }
        }
        return malePersons;
    }
}
