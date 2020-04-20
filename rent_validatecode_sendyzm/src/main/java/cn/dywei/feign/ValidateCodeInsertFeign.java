package cn.dywei.feign;

import cn.dywei.pojo.ValidateCode;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("validatecode-insert")
public interface ValidateCodeInsertFeign {
    @RequestMapping("/validatecode/insert")
    public int insert(@RequestBody ValidateCode validateCode);
}
