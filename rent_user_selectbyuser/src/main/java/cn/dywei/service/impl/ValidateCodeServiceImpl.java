package cn.dywei.service.impl;

import cn.dywei.dao.ValidateCodeDao;
import cn.dywei.pojo.ValidateCode;
import cn.dywei.service.ValidateCodeService;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.ConcurrentHashMap;

@Service
public class ValidateCodeServiceImpl implements ValidateCodeService {
    @Autowired
    private ValidateCodeDao validateCodeDao;
    private ConcurrentHashMap hashMap = new ConcurrentHashMap();
    @Override
    public ValidateCode selectByPhoneCode(String phone, String code) {
        return validateCodeDao.selectByPhoneCode(phone,code);
    }

    /**
     * MongoDB只能使用TCC事务模式。删除之前先查询要删除的数据，把数据放入到全局ConcurrenthashMap
     *
     * @param phone
     * @return
     */
    @Override
    @TccTransaction
    public int deleteByPhone(String phone) {
        ValidateCode validateCode = validateCodeDao.selectByPhone(phone);
        System.out.println(phone+"----"+validateCode+"---"+hashMap);
        hashMap.put(phone,validateCode);
        int index = validateCodeDao.deleteByPhone(phone);
        System.out.println("已经进行了删除");
        return index;
    }

    /**
     * 需要事务滚回执行的方法，把删除的数据重新新增回来
     * @param phone
     */
    public void cancelDeleteByPhone(String phone){
        // 对于目前的代码，可以不查询，但是对于service中代码比较多的时候，建议先查询在新增
        ValidateCode validateCode = validateCodeDao.selectByPhone(phone);
        if(validateCode==null){
            validateCodeDao.insert((ValidateCode) hashMap.get(phone));
        }
    }
}
