package com.itheima;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Springboot16RedisApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    void set() {
        ValueOperations ops = redisTemplate.opsForValue();
        final ValueOperations valueOperations = redisTemplate.opsForValue();
        valueOperations.set("bug", "没有");
        ops.set("age",41);
    }

    @Test
    void get() {
        ValueOperations ops = redisTemplate.opsForValue();
        Object age = ops.get("name");
        Object bug = ops.get("bug");
        System.out.println(bug);
        System.out.println(age);
    }

    @Test
    void hset() {
        HashOperations ops = redisTemplate.opsForHash();
        ops.put("info","b","bb");
        ops.put("info","b","bb1");
    }

    @Test
    void hget() {
        HashOperations ops = redisTemplate.opsForHash();
        Object val = ops.get("info", "b");
        System.out.println(val);
    }

}
