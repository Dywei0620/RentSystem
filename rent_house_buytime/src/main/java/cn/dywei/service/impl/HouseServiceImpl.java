package cn.dywei.service.impl;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.feign.HouseByidFeign;
import cn.dywei.pojo.House;
import cn.dywei.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseByidFeign houseByidFeign;
    @Override
    public rentResult buytime(String id) {
        House house = houseByidFeign.selectById(id);
        rentResult lgr = rentResult.ok();
        lgr.put("time",house.getTime().getTime());
        return lgr;
    }
}
