package cn.dywei.service;

import cn.dywei.commons.pojo.rentResult;
import cn.dywei.pojo.ValidateCode;

public interface ValidateCodeService {
    rentResult validateCode(ValidateCode validateCode);
}
