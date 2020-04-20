package cn.dywei.controller;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    @CrossOrigin
    public rentResult showComment(String id,int page,@RequestParam(defaultValue = "2") int size){
        return commentService.showComment(id,page,size);
    }
}
