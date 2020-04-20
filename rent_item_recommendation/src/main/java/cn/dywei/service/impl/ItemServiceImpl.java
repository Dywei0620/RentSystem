package cn.dywei.service.impl;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.feign.ItemByrecommenFeign;
import cn.dywei.pojo.Item;
import cn.dywei.service.ItemService;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemByrecommenFeign itemByrecommenFeign;
    @Value("${rent.fastdfs.nginx}")
    private String fastdNginxHost;
    @Override
    public rentResult showRecommendation(String city, int size) {
        List<Item> list = itemByrecommenFeign.selectByRecomm(city, size);
        for (Item item :list) {
            item.setImg(fastdNginxHost+item.getImg());
        }
        return rentResult.ok(list);
    }
}
