package cn.dywei.dao.impl;

import cn.dywei.dao.BannerDao;
import cn.dywei.pojo.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BannerDaoImpl implements BannerDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public List<Banner> selectAll() {
        return mongoTemplate.findAll(Banner.class);
    }
}
