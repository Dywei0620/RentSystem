package cn.dywei.dao.impl;

import cn.dywei.dao.ValidateCodeDao;
import cn.dywei.pojo.ValidateCode;
import com.mongodb.client.result.DeleteResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;


@Repository
public class ValidateCodeImpl implements ValidateCodeDao {
    @Autowired
    private MongoTemplate mongoTemplate;
    @Override
    public ValidateCode selectByPhoneCode(String phone, String code) {
        Query query = new Query();
        Criteria criteria = new Criteria();
        criteria.andOperator(Criteria.where("phone").is(phone),Criteria.where("code").is(code));
        query.addCriteria(criteria);
        return mongoTemplate.findOne(query, ValidateCode.class);
    }

    @Override
    public int deleteByPhone(String phone) {
        Query query = new Query(Criteria.where("phone").is(phone));
        DeleteResult result = mongoTemplate.remove(query,ValidateCode.class);
        return (int)result.getDeletedCount();
    }

    @Override
    public ValidateCode selectByPhone(String phone) {
        Query query = new Query(Criteria.where("phone").is(phone));
        return mongoTemplate.findOne(query,ValidateCode.class);
    }

    @Override
    public ValidateCode insert(ValidateCode validateCode) {
        return mongoTemplate.insert(validateCode);
    }
}
