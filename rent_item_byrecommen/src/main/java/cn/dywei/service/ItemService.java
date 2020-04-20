package cn.dywei.service;

import cn.dywei.pojo.Item;

import java.util.List;

public interface ItemService {
    List<Item> selectByRecommen(String city,int size);
}
