package cn.dywei.feign;

import cn.dywei.pojo.Item;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("item-byhot")
public interface ItemByhotFeign {
    @RequestMapping("/item/byhot")
    List<Item> selectByHot(@RequestParam("city") String city, @RequestParam("size") int size);
}
