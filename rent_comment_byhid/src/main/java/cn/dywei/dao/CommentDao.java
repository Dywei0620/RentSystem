package cn.dywei.dao;

import cn.dywei.pojo.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> selectByPage(String hid, int page, int size);

    long count(String hid);
}
