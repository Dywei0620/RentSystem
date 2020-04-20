package cn.dywei.service.impl;

import cn.dywei.dao.ItemDao;
import cn.dywei.pojo.Item;
import cn.dywei.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemDao itemDao;
    @Override
    public List<Item> selectByRecommen(String city, int size) {
        return itemDao.selectByRecommen(city,size);
    }
}
