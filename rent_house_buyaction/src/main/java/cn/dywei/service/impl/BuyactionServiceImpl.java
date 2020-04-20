package cn.dywei.service.impl;

import cn.dywei.service.BuyactionService;
import cn.dywei.commons.pojo.rentResult;
import cn.dywei.pojo.House;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class BuyactionServiceImpl implements BuyactionService {
    @Autowired
    private AmqpTemplate amqpTemplate;
    @Autowired
    private RedisTemplate<String,Object> redisTemplate;
    @Override
    public rentResult buyaction(House house) {
        System.out.println("buyaction");
        // 先查询是否已经被订购
        String key = "rent::house:" + house.getId();

        Object obj = redisTemplate.opsForValue().get(key);
        rentResult rentResult = (rentResult) obj;
        if(rentResult!=null&&rentResult.getData()!=null){
            House houseRedis = (House) rentResult.getData();
            if(houseRedis.getStatus()==0){
                Boolean result = (Boolean) amqpTemplate.convertSendAndReceive("buyaction", house);
                System.out.println("result:"+result);
                if((boolean)result){
                    System.out.println("执行了if");
                    return rentResult.ok();
                }
            }
        }


        return rentResult.error("手太慢，已经被抢订，预订失败");
    }
}
