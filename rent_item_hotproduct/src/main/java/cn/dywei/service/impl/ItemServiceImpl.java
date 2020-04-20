package cn.dywei.service.impl;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.feign.ItemByhotFeign;
import cn.dywei.pojo.Item;
import cn.dywei.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemByhotFeign itemByhotFeign;
    @Value("${rent.fastdfs.nginx}")
    private String fastdNginxHost;
    @Override
    public rentResult showHotProduct(String city, int size) {
        List<Item> list = itemByhotFeign.selectByHot(city, size);
        for (Item item :list) {
            item.setImg(fastdNginxHost+item.getImg());
        }
        return rentResult.ok(list);
    }
}
