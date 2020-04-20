package cn.dywei.dao;

import cn.dywei.pojo.House;
import cn.dywei.pojo.Order;

public interface MongoDao {
    int update(House house);

    Order insertOrder(Order order);
}
