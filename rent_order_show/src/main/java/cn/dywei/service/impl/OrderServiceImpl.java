package cn.dywei.service.impl;

import cn.dywei.service.OrderService;
import cn.dywei.commons.pojo.rentResult;
import cn.dywei.dao.OrderDao;
import cn.dywei.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;
    @Override
    public rentResult showOrder(String user) {
        List<Order> list = orderDao.selectAll(user);
        return rentResult.ok(list);
    }
}
