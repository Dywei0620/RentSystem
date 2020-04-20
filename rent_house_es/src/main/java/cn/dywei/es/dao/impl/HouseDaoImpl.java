package cn.dywei.es.dao.impl;

import cn.dywei.es.dao.HouseDao;
import cn.dywei.pojo.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HouseDaoImpl implements HouseDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<House> selectAll() {
        return mongoTemplate.findAll(House.class);
    }
}
