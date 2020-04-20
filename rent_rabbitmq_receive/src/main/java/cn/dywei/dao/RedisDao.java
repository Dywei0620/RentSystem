package cn.dywei.dao;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.pojo.House;

public interface RedisDao {
    rentResult get(String key);
    void set(String key ,rentResult house);
}
