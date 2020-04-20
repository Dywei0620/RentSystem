package cn.dywei.controller;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @GetMapping("/hotProduct")
    @CrossOrigin
    public rentResult showHotProduct(String city,@RequestParam(defaultValue = "4") int size){
        return itemService.showHotProduct(city,size);
    }
}
