package cn.dywei.controller;

import cn.dywei.service.BuyactionService;
import cn.dywei.commons.pojo.rentResult;
import cn.dywei.pojo.House;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuyactionController {
    @Autowired
    private BuyactionService buyactionService;

    @RequestMapping("/buyaction")
    @CrossOrigin
    public rentResult buyaction(House house){
        System.out.println("控制器");
        return buyactionService.buyaction(house);
    }
}
