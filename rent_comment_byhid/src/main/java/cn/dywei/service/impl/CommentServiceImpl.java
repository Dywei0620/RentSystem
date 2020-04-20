package cn.dywei.service.impl;

import cn.dywei.service.CommentService;
import cn.dywei.dao.CommentDao;
import cn.dywei.pojo.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentDao commentDao;
    @Override
    public List<Comment> selectByPage(String hid, int page, int size) {
        return commentDao.selectByPage(hid, page, size);
    }

    @Override
    public long selectCount(String hid) {
        return commentDao.count(hid);
    }
}
