package cn.dywei.dao.impl;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.dao.RedisDao;
import cn.dywei.pojo.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RedisDaoImpl implements RedisDao {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    @Override
    public rentResult get(String key) {
        return (rentResult) redisTemplate.opsForValue().get(key);
    }

    @Override
    public void set(String key ,rentResult house) {
        redisTemplate.opsForValue().set(key,house);
    }
}
