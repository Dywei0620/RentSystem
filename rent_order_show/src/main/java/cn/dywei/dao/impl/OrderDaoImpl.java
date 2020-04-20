package cn.dywei.dao.impl;

import cn.dywei.dao.OrderDao;
import cn.dywei.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDaoImpl implements OrderDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Order> selectAll(String user) {
        Query query = new Query(Criteria.where("user").is(user));
        return mongoTemplate.find(query,Order.class);
    }
}
