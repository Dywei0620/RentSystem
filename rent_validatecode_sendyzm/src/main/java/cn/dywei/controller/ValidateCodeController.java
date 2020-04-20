package cn.dywei.controller;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.pojo.ValidateCode;
import cn.dywei.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateCodeController {
    @Autowired
    private ValidateCodeService validateCodeService;


    @RequestMapping("/sendyzm")
    @CrossOrigin
    public rentResult validateCode(ValidateCode validateCode){
        return validateCodeService.validateCode(validateCode);
    }
}
