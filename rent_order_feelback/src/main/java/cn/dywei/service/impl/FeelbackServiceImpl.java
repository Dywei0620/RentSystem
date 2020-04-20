package cn.dywei.service.impl;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.dao.FeelbackDao;
import cn.dywei.service.FeelbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeelbackServiceImpl implements FeelbackService {
    @Autowired
    private FeelbackDao feelbackDao;
    @Override
    public rentResult feelback(String orderId, String feelback) {
        int index = feelbackDao.updateFeelbackById(orderId, feelback);
        if(index==1){
            return rentResult.ok();
        }
        return rentResult.error("评论失败");
    }
}
