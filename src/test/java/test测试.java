import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.warehousemanagersystem.WarehouseManagerSystemApplication;
import org.example.warehousemanagersystem.common.RetStatus;
import org.example.warehousemanagersystem.service.ceshi.Impl.Jiekouceshi1;
import org.example.warehousemanagersystem.service.ceshi.Impl.WriteFactory;
import org.example.warehousemanagersystem.service.ceshi.Jiekouceshi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.core.AbstractMessageSendingTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.CommonDataSource;
import java.util.*;
import java.util.stream.IntStream;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-28
 * @Description:
 * @Version: 1.0
 */

@SpringBootTest(classes = WarehouseManagerSystemApplication.class)
@RunWith(SpringRunner.class)
@Slf4j
@ActiveProfiles("test测试")
public class test测试 {
    @Autowired
    Jiekouceshi1 jiekouceshi1;
    @Autowired
    WriteFactory writeFactory;
    @Autowired
    private AbstractMessageSendingTemplate abstractMessageSendingTemplate;
    @Autowired
    private CommonDataSource commonDataSource;

    @Test
    public void 动态规划学习基础(){
        int[] coins={1, 2, 5};
        int amount=11;

    }

    @Test
    public void 测试(){
        Jiekouceshi jiekouceshi = writeFactory.getWrite(1);
        RetStatus<String> write = jiekouceshi.write(1);
        System.out.println(write.getData());

    }
    @Test
    public void 字符串中的单词数(){
        String s=", , , ,        a, eaefa";
        String[] split2 = s.split(" ");
        if (s.isEmpty()||split2.length==0){
            System.out.println(s.length());
        }
        String[] split = s.split(",");
        int sum=split.length;
        if (split[split.length-1].split(" ").length==0){
            sum--;
        }
        for(int i=0;i<split.length;i++){
            String[] split1 = split[i].split(" ");
            List<String> list=new ArrayList<>();
            for(int j=0;j<split1.length;j++){
                if(!split1[j].equals(" ")&& !split1[j].isEmpty()){
                    list.add(split1[j]);
                }
            }
            if(!list.isEmpty()){
                sum=sum+list.size()-1;
            }

        }

        System.out.println(sum);
    }
    @Test
    public void 找到所有数组中消失的数字(){
       int[] nums = {4,3,2,7,8,2,3,1};
       int length=nums.length;
      Map<Integer,Integer> map=new HashMap<>();
       for (int i = 0; i < length; i++) {
           map.put(nums[i],1);
       }
       List<Integer> list=new ArrayList<>();
       for (int i=0;i<length+1;i++){
           if (map.get(i+1)==null) {
               list.add(i+1);
           }
       }
        System.out.println(list);
    }
    @Test
    public void 分发饼干(){
        Integer[] g={10,9,8,7};
        Integer[] s={5,6,7,8};
        List<Integer> list = new ArrayList<>(Arrays.asList(g));
        List<Integer> list1 = new ArrayList<>(Arrays.asList(s));
        int count = 0;

// 使用迭代器安全删除
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer num = iterator.next();
            Iterator<Integer> iterator1 = list1.iterator();
            boolean found = false;

            while (iterator1.hasNext()) {
                Integer num1 = iterator1.next();
                if (num.equals(num1)) {
                    iterator1.remove();
                    found = true;
                    break;
                }
            }

            if (found) {
                iterator.remove();
                count++;
            }
        }
        System.out.println(count);



    }
    @Test
    public void 重复的子字符串(){
        String s="abcabcabcabc";
        if (s.length()==1){
            System.out.println(true);
          //  return true;
        }
        StringBuffer sb=new StringBuffer();
        boolean flag=true;
        for (int i = 0; i < s.length(); i++) {
            sb.append(s.charAt(i));
            int j=0;
            while (j<s.length()-sb.length()) {

                String substring = s.substring(j, j+ sb.length());
                if (!substring.contentEquals(sb)) {
                    j=0;
                    flag=false;
                    break;
                }else {
                    flag=true;

                }
                j+=sb.length();
            }
            if(flag){
                System.out.println(true);
               // return true;
            }

        }
        System.out.println(false);
       // return false;
    }

}
