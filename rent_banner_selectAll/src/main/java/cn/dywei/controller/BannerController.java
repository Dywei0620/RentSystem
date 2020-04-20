package cn.dywei.controller;

import cn.dywei.service.BannerService;
import cn.dywei.pojo.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BannerController {
    @Autowired
    private BannerService bannerService;

    @RequestMapping("/banner/selectAll")
    public List<Banner> selectAll(){
        return bannerService.selectAll();
    }
}
