package cn.dywei.service;

import cn.dywei.commons.pojo.rentResult;
import org.springframework.stereotype.Service;

public interface FeelbackService {
    rentResult feelback(String orderId,String feelback);
}
