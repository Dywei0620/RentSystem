package cn.dywei.dao.impl;

import cn.dywei.dao.CommentDao;
import cn.dywei.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDaoImpl implements CommentDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Comment> selectByPage(String hid, int page, int size) {
        Query query = new Query(Criteria.where("hid").is(hid));
        query.with(PageRequest.of(page,size));
        return mongoTemplate.find(query,Comment.class);
    }

    @Override
    public long count(String hid) {
        Query query = new Query(Criteria.where("hid").is(hid));
        return mongoTemplate.count(query,Comment.class);
    }
}
