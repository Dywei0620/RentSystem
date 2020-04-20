package cn.dywei.controller;

import cn.dywei.pojo.ValidateCode;
import cn.dywei.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ValidateCodeController {
    @Autowired
    private ValidateCodeService validateCodeService;
    @RequestMapping("/validatecode/insert")
    public int insert(@RequestBody ValidateCode validateCode){
        return validateCodeService.insert(validateCode);
    }
}
