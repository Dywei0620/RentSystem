package cn.dywei.service;

import cn.dywei.pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> selectByPage(String hid,int page,int size);

    long selectCount(String hid);
}
