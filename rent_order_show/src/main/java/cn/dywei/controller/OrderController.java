package cn.dywei.controller;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/order")
    @CrossOrigin
    public Object showOrder(String user){
        return orderService.showOrder(user).getData();
    }
}
