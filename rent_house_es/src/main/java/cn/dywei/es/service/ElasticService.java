package cn.dywei.es.service;

import cn.dywei.es.pojo.ESHouse;

import java.util.List;

public interface ElasticService {
    boolean init();

    long count(String city,String keyword);

    List<ESHouse> selectByPage(String city,String keyword,int page,int size);
}
