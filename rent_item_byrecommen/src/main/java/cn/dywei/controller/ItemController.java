package cn.dywei.controller;

import cn.dywei.service.ItemService;
import cn.dywei.pojo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/recommendation")
    public List<Item> selectByRecommen(String city, @RequestParam(defaultValue = "4") int size){
        return itemService.selectByRecommen(city,size);
    }
}
