package cn.dywei.service.impl;

import cn.dywei.service.UserService;
import cn.dywei.commons.pojo.rentResult;
import cn.dywei.feign.UserSelectByUserFeign;
import cn.dywei.pojo.Users;
import cn.dywei.pojo.ValidateCode;
import com.codingapi.txlcn.tc.annotation.TccTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UserService {
    @Autowired
    private UserSelectByUserFeign userSelectByUserFeign;
    @Override
    @TccTransaction
    public rentResult login(Users users) {
        ValidateCode vc = userSelectByUserFeign.selectByPhoneCode(users.getUsername(), users.getPassword());
        if(vc!=null){
            Users user = userSelectByUserFeign.selectByUsername(users.getUsername());
            if(user==null){
                // insert参数是login方法参数，不是返回值
                users.setPassword("");
                int index = userSelectByUserFeign.insert(users);
                if(index==1){
                    int deleteResult = userSelectByUserFeign.deleteByPhone(users.getUsername());
                    if(deleteResult==1){
                        return rentResult.ok();
                    }
                }
            }else{
                return rentResult.ok();
            }
        }
        return rentResult.error("登录失败");
    }
}
