package cn.dywei.controller;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.pojo.Users;
import cn.dywei.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsersController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    @CrossOrigin
    public rentResult login(Users user){
        return userService.login(user);
    }
}
