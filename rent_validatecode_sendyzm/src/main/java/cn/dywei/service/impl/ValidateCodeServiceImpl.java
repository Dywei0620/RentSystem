package cn.dywei.service.impl;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.feign.ValidateCodeInsertFeign;
import cn.dywei.pojo.ValidateCode;
import cn.dywei.service.ValidateCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Random;

@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {
    @Autowired
    private ValidateCodeInsertFeign validateCodeInsertFeign;
    @Override
    public rentResult validateCode(ValidateCode validateCode) {
        // 调用短信平台生成验证码。模拟生成。
        StringBuffer sf = new StringBuffer();
        Random random = new Random();
        for(int i =0;i<4;i++){
            sf.append(random.nextInt(10));
        }
        validateCode.setCode(sf.toString());
        System.out.println("验证码："+sf.toString());
        validateCode.setTime(new Date());
        int result = validateCodeInsertFeign.insert(validateCode);
        if(result==1){
            return rentResult.ok();
        }
        return rentResult.error("验证码生成失败");
    }
}
