package cn.dywei.service;

import cn.dywei.pojo.Users;

public interface UsersService {
    Users selectByUsername(String username);
    int insert(Users user);
}
