package cn.dywei.es.service.impl;

import cn.dywei.es.service.ElasticService;
import cn.dywei.es.dao.HouseDao;
import cn.dywei.es.pojo.ESHouse;
import cn.dywei.pojo.House;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ElasticServiceImpl implements ElasticService {
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private HouseDao houseDao;
    @Override
    public boolean init() {
        try {
            boolean result = elasticsearchTemplate.createIndex(ESHouse.class);
            boolean result2 = elasticsearchTemplate.putMapping(ESHouse.class);
            if(result&&result2){
                List<House> list = houseDao.selectAll();
                List<IndexQuery> listBulk = new ArrayList<>();
                for(House house : list){
                    ESHouse esHouse = new ESHouse();
                    BeanUtils.copyProperties(house,esHouse);
                    esHouse.setImg(house.getImgs()[0]);
                    listBulk.add(new IndexQueryBuilder().withObject(esHouse).build());
                }
                elasticsearchTemplate.bulkIndex(listBulk);
                return true;
            }
        } catch (BeansException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public long count(String city, String keyword) {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        List<QueryBuilder> list= new ArrayList<>();
        // match phrase 对条件不拆词
        list.add(QueryBuilders.matchPhraseQuery("city",city));
        // match 对条件进行拆词
        list.add(QueryBuilders.matchQuery("title",keyword));
        boolQueryBuilder.must().addAll(list);
        SearchQuery searchQuery = new NativeSearchQuery(boolQueryBuilder);
        return elasticsearchTemplate.count(searchQuery,ESHouse.class);
    }

    @Override
    public List<ESHouse> selectByPage(String city, String keyword,int page,int size) {
        BoolQueryBuilder boolQueryBuilder = new BoolQueryBuilder();
        List<QueryBuilder> list= new ArrayList<>();
        // match phrase 对条件不拆词
        list.add(QueryBuilders.matchPhraseQuery("city",city));
        // match 对条件进行拆词
        list.add(QueryBuilders.matchQuery("title",keyword));
        boolQueryBuilder.must().addAll(list);
        SearchQuery searchQuery = new NativeSearchQuery(boolQueryBuilder);
        searchQuery.setPageable(PageRequest.of(page,size));
        return elasticsearchTemplate.queryForList(searchQuery,ESHouse.class);
    }
}
