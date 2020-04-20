package cn.dywei.service;

import cn.dywei.commons.pojo.rentResult;

public interface HouseService {
    rentResult search(String city,String keyword,int page,int size);
}
