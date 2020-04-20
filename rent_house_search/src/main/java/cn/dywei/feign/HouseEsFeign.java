package cn.dywei.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@FeignClient("house-es")
public interface HouseEsFeign {
    @RequestMapping("/house/count")
    long count(@RequestParam("city") String city,@RequestParam("keyword") String keyword);
    @RequestMapping("/house/search")
    List<Map<String,Object>> selectByPage(@RequestParam("city") String city,@RequestParam("keyword") String keyword,@RequestParam("page") int page,@RequestParam("size") int size);
}
