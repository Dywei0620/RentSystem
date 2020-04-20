package cn.dywei.controller;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/recommendation")
    @CrossOrigin
    public rentResult showRecommendation(String city,@RequestParam(defaultValue = "4") int size){
        return itemService.showRecommendation(city, size);
    }
}
