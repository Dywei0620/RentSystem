package cn.dywei.dao.impl;

import cn.dywei.dao.MongoDao;
import cn.dywei.pojo.House;
import cn.dywei.pojo.Order;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;


@Repository
public class MongoDaoImpl implements MongoDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public int update(House house) {
        Query query = new Query(Criteria.where("id").is(house.getId()));
        Update update= new Update();
        update.set("status",1);
        update.set("user",house.getUser());
        UpdateResult result = mongoTemplate.updateFirst(query, update, House.class);
        return (int) result.getModifiedCount();
    }

    @Override
    public Order insertOrder(Order order) {
        return mongoTemplate.insert(order);
    }
}
