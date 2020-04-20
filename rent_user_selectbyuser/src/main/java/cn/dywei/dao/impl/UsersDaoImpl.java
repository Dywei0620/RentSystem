package cn.dywei.dao.impl;

import cn.dywei.dao.UsersDao;
import cn.dywei.pojo.Users;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class UsersDaoImpl implements UsersDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public Users selectByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        return mongoTemplate.findOne(query, Users.class);
    }

    // 如果添加lcn就不能添加try..catch 捕获不到异常，无法进行回滚
    @Override
    public Users insert(Users user) {
        return mongoTemplate.insert(user);
    }

    @Override
    public int deleteByUsername(String username) {
        Query query = new Query(Criteria.where("username").is(username));
        DeleteResult result = mongoTemplate.remove(query,Users.class);
        return (int) result.getDeletedCount();
    }
}
