package cn.dywei.controller;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;

    @RequestMapping("/search")
    @CrossOrigin
    public rentResult search(@RequestParam(required = true) String city,@RequestParam(required = true)String content,@RequestParam(required = true)int page,@RequestParam(defaultValue = "3") int size){
        return houseService.search(city, content, page, size);
    }
}
