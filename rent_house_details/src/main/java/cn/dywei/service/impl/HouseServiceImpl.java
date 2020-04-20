package cn.dywei.service.impl;

import cn.dywei.service.HouseService;
import cn.dywei.commons.pojo.rentResult;
import cn.dywei.feign.HouseByIdFeign;
import cn.dywei.pojo.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames = "rent")
@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseByIdFeign houseByIdFeign;
    @Value("${rent.fastdfs.nginx}")
    private String fastdNginxHost;
    @Cacheable(key = "'house:'+#id")
    @Override
    public rentResult showDetails(String id) {
        House house = houseByIdFeign.selectById(id);
        String[] imgs = house.getImgs();
        for(int i =0;i<imgs.length;i++){
            imgs[i]=fastdNginxHost+imgs[i];
        }
        return rentResult.ok(house);
    }
}
