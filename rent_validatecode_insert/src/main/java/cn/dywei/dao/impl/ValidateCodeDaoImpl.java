package cn.dywei.dao.impl;

import cn.dywei.dao.ValidateCodeDao;
import cn.dywei.pojo.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ValidateCodeDaoImpl implements ValidateCodeDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public ValidateCode insert(ValidateCode validateCode) {
        try {
            return mongoTemplate.insert(validateCode);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
