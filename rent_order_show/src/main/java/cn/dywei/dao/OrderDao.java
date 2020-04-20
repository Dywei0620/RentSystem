package cn.dywei.dao;

import cn.dywei.pojo.Order;

import java.util.List;

public interface OrderDao {
    List<Order> selectAll(String user);
}
