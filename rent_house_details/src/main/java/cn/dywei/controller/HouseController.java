package cn.dywei.controller;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HouseController {
    @Autowired
    private HouseService houseService;

    @GetMapping("/details")
    @CrossOrigin
    public Object details(@RequestParam(required = true) String id){

        return houseService.showDetails(id).getData();
    }
}
