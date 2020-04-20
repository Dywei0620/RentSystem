package cn.dywei.service;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.dao.MongoDao;
import cn.dywei.dao.RedisDao;
import cn.dywei.pojo.House;
import cn.dywei.pojo.Order;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class ReceiveService {
    @Autowired
    private RedisDao redisDao;
    @Autowired
    private MongoDao mongoDao;

    @RabbitListener(bindings = @QueueBinding(value = @Queue(name = "buyaction"),exchange = @Exchange(name = "amq.direct")))
    public boolean buyaction(Message msg){
        try {
            byte[] body = msg.getBody();
            ByteArrayInputStream bis = new ByteArrayInputStream(body);
            ObjectInputStream ois = new ObjectInputStream(bis);
            Object result = ois.readObject();
            House house = (House) result;
            //1. 从redis中去取
            String key ="rent::house:" + house.getId();
            rentResult rentResult = redisDao.get(key);
            House houseRedis = (House) rentResult.getData();
            if(houseRedis.getStatus()==0){// 未出租
                houseRedis.setStatus(1);
                houseRedis.setUser(house.getUser());
                // 修改缓存中数据
                redisDao.set(key,rentResult);
                // 修改mongodb中数据
                mongoDao.update(houseRedis);
                // 生成订单数据
                Order order = new Order();
                order.setCommentState(0);
                order.setHouseType(houseRedis.getHouseType());
                order.setImg(houseRedis.getImgs()[0]);
                order.setPrice(houseRedis.getPrice());
                order.setRentType(houseRedis.getRentType());
                order.setTitle(houseRedis.getTitle());
                order.setUser(house.getUser());
                mongoDao.insertOrder(order);
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }
}
