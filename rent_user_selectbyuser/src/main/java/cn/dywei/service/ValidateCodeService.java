package cn.dywei.service;

import cn.dywei.pojo.ValidateCode;

public interface ValidateCodeService {
    ValidateCode selectByPhoneCode(String phone,String code);

    int deleteByPhone(String phone);
}
