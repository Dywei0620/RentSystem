package cn.dywei.controller;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BannerController {
    @Autowired
    private BannerService bannerService;
    @GetMapping("/banner")
    @CrossOrigin
    public rentResult showBanner(){
        return bannerService.showBanner();
    }
}
