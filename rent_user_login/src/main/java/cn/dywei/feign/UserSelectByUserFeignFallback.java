package cn.dywei.feign;

import cn.dywei.pojo.Users;
import cn.dywei.pojo.ValidateCode;
import org.springframework.stereotype.Component;

@Component
public class UserSelectByUserFeignFallback implements UserSelectByUserFeign {
    @Override
    public int insert(Users user) {
        // 新增失败是0
        return 0;
    }

    @Override
    public Users selectByUsername(String username) {
        // 查询失败是null
        return null;
    }

    @Override
    public ValidateCode selectByPhoneCode(String phone, String code) {
        // 查询失败是null
        return null;
    }

    @Override
    public int deleteByPhone(String phone) {
        // 删除失败0
        return 0;
    }
}
