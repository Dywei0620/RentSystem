package cn.dywei.service.impl;

import cn.dywei.dao.HouseDao;
import cn.dywei.pojo.House;
import cn.dywei.service.HouseSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseSerivce {
    @Autowired
    private HouseDao houseDao;
    @Override
    public House selectById(String id) {
        return houseDao.selectById(id);
    }
}
