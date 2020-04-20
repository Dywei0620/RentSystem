package cn.dywei.dao.impl;

import cn.dywei.dao.HouseDao;
import cn.dywei.pojo.House;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class HouseDaoImpl implements HouseDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public House selectById(String id) {
        return mongoTemplate.findById(id,House.class);
    }

    public static void main(String[] args) {
        Date date = new Date(1582769512529l);
        System.out.println(date.toLocaleString());
    }
}
