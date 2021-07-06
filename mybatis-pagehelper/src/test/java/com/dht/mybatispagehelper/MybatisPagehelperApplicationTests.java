package com.dht.mybatispagehelper;

import com.dht.mybatispagehelper.config.RedisUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

@SpringBootTest
class MybatisPagehelperApplicationTests {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    @Test
    void contextLoads() {
    }

    @Test
    public void set() {
        redisTemplate.opsForValue().set("myKey", "myValue");
        System.out.println(redisTemplate.opsForValue().get("myKey"));
    }

    @Test
    public void set1() {
        redisUtil.set("k1", "k2", 60);
        System.out.println(redisUtil.get("k1"));
    }

    @Test
    public void get() {
        System.out.println(redisUtil.get("k1"));
    }
}
