package cn.dywei.service.impl;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.feign.BannerSelectallFeign;
import cn.dywei.pojo.Banner;
import cn.dywei.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerSelectallFeign bannerSelectallFeign;
    @Value("${rent.fastdfs.nginx}")
    private String fastdNginxHost;
    @Override
    public rentResult showBanner() {
        List<Banner> list = bannerSelectallFeign.selectAll();
        rentResult lgr = new rentResult();
        lgr.setStatus(200);
        List<String> results = new ArrayList<>();
        for (Banner banner: list) {
            results.add(fastdNginxHost+banner.getPath());
        }
        lgr.put("results",results);
        return lgr;
    }
}
