package org.example.warehousemanagersystem.common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Author: 沈琪
 * @CreateTime: 2025-10-11
 * @Description:
 * @Version: 1.0
 */

@Component
public class RedisService {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 设置字符串值
     */
    public void setValue(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * 设置带过期时间的字符串值
     */
    public void setValueWithExpire(String key, Object value, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, value, timeout, unit);
    }

    /**
     * 设置哈希值
     */
    public void setHashValue(String key, String hashKey, Object value) {
        redisTemplate.opsForHash().put(key, hashKey, value);
    }

    /**
     * 设置列表值
     */
    public void setListValue(String key, Object value) {
        redisTemplate.opsForList().rightPush(key, value);
    }
}
