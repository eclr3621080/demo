import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.WarehouseManagerSystemApplication;
import org.example.warehousemanagersystem.common.RedisService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.types.RedisClientInfo;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@SpringBootTest(classes = WarehouseManagerSystemApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
@ActiveProfiles("sqtest")
public class sqtest {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;
    @Autowired
    RedisService redisService;
    @Test
    public void test(){
        redisTemplate.opsForValue().set("sqsq","111",30, TimeUnit.MINUTES);
    }
    @Test
    public void test1(){
        Set<String> keys = redisTemplate.keys("*");
        if (keys != null) {
            for (String key : keys) {
                Object value = redisTemplate.opsForValue().get(key);
                System.out.println("Key: " + key + ", Value: " + value);
            }
        }

        System.out.println(keys);
    }

    @Test
    public void 学习Option(){
        Optional<String> empty = Optional.empty();
        System.out.println(empty);
        Optional<String> opt = Optional.of("沉默王二");
        System.out.println(opt); // 输出：Optional[沉默王二]
        String name = null;
        Optional<String> optOrNull = Optional.ofNullable(name);
        System.out.println(optOrNull); // 输出：Optional.empty
    }

    /**
     * 后面的每一项数字都是前面两项数字的和。
     */
    @Test
    public void 斐波那契数列(){
         int n=10;
         int[] arr=new int[n];
         arr[0]=0;
         arr[1]=1;
         for(int i=2;i<n;i++){
             arr[i]=arr[i-1]+arr[i-2];
         }
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void stream流学习(){
//        List<String> list = new ArrayList<>();
//        list.add("张无忌");
//        list.add("周芷若");
//        list.add("赵敏");
//        list.add("小昭");
//        list.add("殷离");
//        list.add("张三");
//        list.add("张三丰");
//        //List<String> collect = list.stream().filter(e -> e.length() > 3).collect(Collectors.toList());
//        list.stream().parallel().filter(e -> e.length() > 2).forEach(e -> System.out.println(e));
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Tom", 8900, 21,"male", "New York"));
        personList.add(new Person("Jack", 7000, 22,"male", "Washington"));
        personList.add(new Person("Lily", 7800, 24,"female", "Washington"));
        personList.add(new Person("Anni", 8200, 26,"female", "New York"));
        personList.add(new Person("Owen", 9500, 27,"male", "New York"));
        personList.add(new Person("Alisa", 7900, 28,"female", "New York"));
        List<Person> personList1 = new ArrayList<>();
        personList1.add(new Person("Tom", 8900, 21,"male", "New York"));
        personList1.add(new Person("Jack1", 7000, 22,"male", "Washington"));
        personList1.add(new Person("Lily1", 7800, 24,"female", "Washington"));
        personList1.add(new Person("Anni", 8200, 26,"female", "New York"));
        personList1.add(new Person("Owen", 9500, 27,"male", "New York"));
        personList1.add(new Person("Alisa1", 7900, 28,"female", "New York"));
        List<String> collect = personList.stream().filter(e -> e.age > 21).map(Person::getName).collect(Collectors.toList());
        List<Integer> collectAge = personList.stream().filter(e -> e.age > 21).map(Person::getAge).collect(Collectors.toList());
//        collect.forEach(System.out::println);
        //比较字符串
        Optional<Integer> max = collectAge.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        List<Person> collect1 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 1000);
            return person;
        }).collect(Collectors.toList());
//        collect1.forEach(System.out::println);
//        max.ifPresent(System.out::println);

//        collect.stream().map(String::toUpperCase).forEach(System.out::println);

//        Optional<Integer> sumSalary = personList.stream().map(Person::getSalary).reduce(Integer::sum);
//        System.out.println(sumSalary);
        List<String> collect2 = personList.stream().sorted(Comparator.comparing(Person::getSalary)).map(Person::getName).collect(Collectors.toList());
        System.out.println(collect2);
        List<String> collect3 = personList.stream().map(Person::getName).collect(Collectors.toList());
        List<String> collect4 = personList1.stream().map(Person::getName).collect(Collectors.toList());

        Stream<String> stream1 = collect3.stream();
        Stream<String> stream2 = collect4.stream();
        List<String> collect5 = Stream.concat(stream1, stream2).distinct().collect(Collectors.toList());
        System.out.println(collect5);

    }
    @Test
    public void 去重(){

    }
    @Test
    public void reducestudy(){
        //比较数字
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        Optional<Integer> sum = list.stream().reduce((x, y) -> x + y);
//        System.out.println(sum.orElse(0));
        //求最大值
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x > y ? x : y);
        // 求最大值写法2
        Integer max2 = list.stream().reduce(1, Integer::max);
        System.out.println(max2);
//        System.out.println(reduce.orElse(0));
    }


    class Person {
        private String name;  // 姓名
        private int salary; // 薪资
        private int age; // 年龄
        private String sex; //性别
        private String area;  // 地区

        // 构造方法
        public Person(String name, int salary, int age,String sex,String area) {
            this.name = name;
            this.salary = salary;
            this.age = age;
            this.sex = sex;
            this.area = area;
        }


        public String getName() {
            return name;
        }
        public Integer getSalary() {
            return salary;
        }
        public void setSalary(Integer salary) {
            this.salary = salary;
        }
        public Integer getAge() {
            return age;
        }
    }



}
