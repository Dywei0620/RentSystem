package cn.dywei.controller;

import cn.dywei.pojo.Users;
import cn.dywei.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @RequestMapping("/user/insert")
    public int insert(@RequestBody Users user){
        return usersService.insert(user);
    }

    @RequestMapping("/user/selectByUsername")
    public Users selectByUsername(String username){
        return usersService.selectByUsername(username);
    }
}
