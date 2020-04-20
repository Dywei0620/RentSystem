package cn.dywei.controller;

import cn.dywei.service.FeelbackService;
import cn.dywei.commons.pojo.rentResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeelbackController {
    @Autowired
    private FeelbackService feelbackService;

    @RequestMapping("/feelback")
    @CrossOrigin
    public rentResult feelback(String orderId,String feelback){
        return feelbackService.feelback(orderId,feelback);
    }
}
