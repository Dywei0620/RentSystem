package cn.dywei.es.controller;

import cn.dywei.es.pojo.ESHouse;
import cn.dywei.es.service.ElasticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ElasticController {

    @Autowired
    private ElasticService elasticService;

    @RequestMapping("/es/init")
    public boolean init(){
        return elasticService.init();
    }


    @RequestMapping("/house/search")
    public List<ESHouse> search(@RequestParam(required = true) String city, @RequestParam(required = true) String keyword, @RequestParam(required = true) int page, @RequestParam(defaultValue = "3") int size){
        return elasticService.selectByPage(city,keyword,page,size);
    }
    @RequestMapping("/house/count")
    public long count(@RequestParam(required = true) String city, @RequestParam(required = true) String keyword){
        return  elasticService.count(city,keyword);
    }
}
