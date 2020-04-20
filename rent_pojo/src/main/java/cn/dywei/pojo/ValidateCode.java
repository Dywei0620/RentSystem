package cn.dywei.pojo;

import java.util.Date;

public class ValidateCode {
    private String id;
    // 用户名，就是手机号
    private String phone;
    // 验证码
    private String code;
    // 生成验证码时间
    private Date time;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
