package cn.dywei.controller;

import cn.dywei.service.ValidateCodeService;
import cn.dywei.pojo.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateCodeController {
    @Autowired
    private ValidateCodeService validateCodeService;

    @RequestMapping("/validatecode/selectByPhoneCode")
    public ValidateCode selectByPhoneCode(String phone,String code){
        return validateCodeService.selectByPhoneCode(phone,code);
    }


    @RequestMapping("/validatecode/deleteByPhone")
    public int deleteByPhone(String phone){
        return validateCodeService.deleteByPhone(phone);
    }
}
