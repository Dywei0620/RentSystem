package cn.dywei.feign;

import cn.dywei.pojo.Banner;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient("banner-selectAll")
public interface BannerSelectallFeign {
    @RequestMapping("/banner/selectAll")
    List<Banner> selectAll();
}
