package cn.dywei.feign;

import cn.dywei.pojo.Comment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("comment-byhid")
public interface CommentByidFeign {
    @RequestMapping("/comment/selectBypage")
    List<Comment> selectByPage(@RequestParam("hid") String hid,@RequestParam("page") int page,@RequestParam("size") int size);

    @RequestMapping("/comment/count")
    long count(@RequestParam("hid")String hid);
}
