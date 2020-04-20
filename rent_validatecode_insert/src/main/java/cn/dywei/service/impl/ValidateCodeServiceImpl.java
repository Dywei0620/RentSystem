package cn.dywei.service.impl;

import cn.dywei.service.ValidateCodeService;
import cn.dywei.dao.ValidateCodeDao;
import cn.dywei.pojo.ValidateCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {
    @Autowired
    private ValidateCodeDao validateCodeDao;
    @Override
    public int insert(ValidateCode validateCode) {
        ValidateCode result = validateCodeDao.insert(validateCode);
        if(result!=null){
            return 1;
        }
        return 0;
    }
}
