package cn.dywei.controller;

import cn.dywei.pojo.Comment;
import cn.dywei.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @RequestMapping("/comment/count")
    public long count(String hid){
        return commentService.selectCount(hid);
    }

    @RequestMapping("/comment/selectBypage")
    public List<Comment> selectByPage(String hid, int page ,int size){
        return commentService.selectByPage(hid, page, size);
    }
}
