package cn.dywei.service.impl;

import cn.dywei.service.HouseService;
import cn.dywei.commons.pojo.rentResult;
import cn.dywei.feign.HouseEsFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    private HouseEsFeign houseEsFeign;
    @Value("${rent.fastdfs.nginx}")
    private String fastdNginxHost;
    @Override
    public rentResult search(String city, String keyword, int page,int size) {
        List<Map<String, Object>> list = houseEsFeign.selectByPage(city, keyword, page,size);
        for(Map<String,Object> map : list){
            map.put("img",fastdNginxHost+map.get("img"));
        }
        rentResult lgr = rentResult.ok(list);
        long count = houseEsFeign.count(city, keyword);
        long totalPage = count%size==0?count/size:count/size+1;
        lgr.put("hasMore",totalPage>page?true:false);
        return lgr;
    }
}
