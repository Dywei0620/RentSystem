package cn.dywei.service;

import cn.dywei.commons.pojo.rentResult;

public interface ItemService {
    rentResult showRecommendation(String city,int size);
}
