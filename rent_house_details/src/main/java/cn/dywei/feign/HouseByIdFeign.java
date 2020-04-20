package cn.dywei.feign;

import cn.dywei.pojo.House;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("house-byid")
public interface HouseByIdFeign {
    @RequestMapping("/house/selectById")
    House selectById(@RequestParam("id") String id);
}
