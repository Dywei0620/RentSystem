package cn.dywei.service.impl;

import cn.dywei.service.CommentService;
import cn.dywei.commons.pojo.rentResult;
import cn.dywei.feign.CommentByidFeign;
import cn.dywei.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentByidFeign commentByidFeign;
    @Override
    public rentResult showComment(String id, int page, int size) {
        List<Comment> list = commentByidFeign.selectByPage(id, page, size);
        rentResult result = rentResult.ok(list);
        long count = commentByidFeign.count(id);
        long totalPage = count%size==0?count/size:count/size+1;
        result.put("hasMore",totalPage>page?true:false);
        return result;
    }
}
