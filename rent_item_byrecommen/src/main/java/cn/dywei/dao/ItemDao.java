package cn.dywei.dao;

import cn.dywei.pojo.Item;

import java.util.List;

public interface ItemDao {
    List<Item> selectByRecommen(String city,int size);
}
