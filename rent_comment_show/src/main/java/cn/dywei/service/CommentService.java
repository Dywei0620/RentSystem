package cn.dywei.service;

import cn.dywei.commons.pojo.rentResult;

public interface CommentService {
    rentResult showComment(String id,int page,int size);
}
