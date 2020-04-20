package cn.dywei.dao.impl;

import cn.dywei.dao.FeelbackDao;
import cn.dywei.pojo.Order;
import com.mongodb.client.result.UpdateResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

@Repository
public class FeelbackDaoImpl implements FeelbackDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public int updateFeelbackById(String id, String feelback) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("feelback",feelback);
        UpdateResult result = mongoTemplate.updateFirst(query, update, Order.class);
        return (int) result.getModifiedCount();
    }
}
