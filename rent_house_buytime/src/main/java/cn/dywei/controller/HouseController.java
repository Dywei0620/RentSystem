package cn.dywei.controller;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("/buytime")
    @CrossOrigin
    public rentResult buytime(String id){
        return houseService.buytime(id);
    }
}
