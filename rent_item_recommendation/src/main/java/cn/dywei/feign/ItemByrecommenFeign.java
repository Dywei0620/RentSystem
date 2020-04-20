package cn.dywei.feign;

import cn.dywei.pojo.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("item-recommen")
public interface ItemByrecommenFeign {
    @GetMapping("/item/recommendation")
    List<Item> selectByRecomm(@RequestParam("city") String city,@RequestParam("size") int size);
}
