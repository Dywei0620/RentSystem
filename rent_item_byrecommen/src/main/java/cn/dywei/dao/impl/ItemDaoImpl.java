package cn.dywei.dao.impl;

import cn.dywei.dao.ItemDao;
import cn.dywei.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDaoImpl implements ItemDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Item> selectByRecommen(String city, int size) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("city").is(city),Criteria.where("recommendation").is(true));
        query.addCriteria(criteria);
        query.with(Sort.by(Sort.Order.asc("recoSort")));
        query.with(PageRequest.of(0,size));
        return mongoTemplate.find(query,Item.class);
    }
}
