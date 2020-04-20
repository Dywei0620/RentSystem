package cn.dywei.service;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.pojo.Users;

public interface UserService {
    rentResult login(Users users);
}
