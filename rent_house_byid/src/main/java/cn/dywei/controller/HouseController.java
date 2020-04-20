package cn.dywei.controller;

import cn.dywei.pojo.House;
import cn.dywei.service.HouseSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {
    @Autowired
    private HouseSerivce houseSerivce;
    @RequestMapping("/house/selectById")
    public House selectById(String id){
        return houseSerivce.selectById(id);
    }
}
