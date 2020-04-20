package cn.dywei.service.impl;

import cn.dywei.dao.BannerDao;
import cn.dywei.pojo.Banner;
import cn.dywei.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BannerServiceImpl implements BannerService {
    @Autowired
    private BannerDao bannerDao;
    @Override
    public List<Banner> selectAll() {
        return bannerDao.selectAll();
    }
}
