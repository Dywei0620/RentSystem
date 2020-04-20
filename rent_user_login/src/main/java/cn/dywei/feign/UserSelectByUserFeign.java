package cn.dywei.feign;

import cn.dywei.pojo.Users;
import cn.dywei.pojo.ValidateCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "user-selectbyuser",fallback = UserSelectByUserFeignFallback.class)
public interface UserSelectByUserFeign {
    @RequestMapping("/user/insert")
    int insert(@RequestBody Users user);

    @RequestMapping("/user/selectByUsername")
    Users selectByUsername(@RequestParam("username") String username);

    @RequestMapping("/validatecode/selectByPhoneCode")
    ValidateCode selectByPhoneCode(@RequestParam("phone") String phone, @RequestParam("code") String code);

    @RequestMapping("/validatecode/deleteByPhone")
    int deleteByPhone(@RequestParam("phone") String phone);
}
