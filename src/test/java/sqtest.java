import lombok.extern.slf4j.Slf4j;
import org.example.warehousemanagersystem.WarehouseManagerSystemApplication;
import org.example.warehousemanagersystem.common.RedisService;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

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
    @Test
    public void test(){
        redisTemplate.opsForValue().set("sqsq","111",30, TimeUnit.MINUTES);
    }
    @Test
    public void test1(){
        Object o = redisTemplate.opsForValue().get("sqsq");
        System.out.println(o.toString());
    }


}
