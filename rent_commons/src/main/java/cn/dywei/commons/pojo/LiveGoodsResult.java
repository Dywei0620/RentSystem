package cn.dywei.commons.pojo;

import java.util.HashMap;

/**
 * 服务端和客户端交互模板
 */
public class rentResult extends HashMap<String,Object> {
    // 返回状态值
    private int status;
    // 服务端返回数据
    private Object data;
    // 服务端返回消息
    private String msg;

    public static rentResult ok(){
        rentResult lgr = new rentResult();
        lgr.setStatus(200);
        lgr.setMsg("ok");
        return lgr;
    }
    public static rentResult ok(Object data){
        rentResult lgr = new rentResult();
        lgr.setStatus(200);
        lgr.setMsg("ok");
        lgr.setData(data);
        return lgr;
    }

    public static rentResult error(String msg){
        rentResult lgr = new rentResult();
        lgr.setStatus(500);
        lgr.setMsg(msg);
        return lgr;
    }

    public int getStatus() {
        return this.get("status")==null?0:Integer.parseInt(this.get("status").toString());
    }

    public void setStatus(int status) {
        this.put("status",status);
    }

    public Object getData() {

        return this.get("data");
    }

    public void setData(Object data) {
        this.put("data",data);
    }

    public String getMsg() {
        return this.get("status")==null?"":this.get("msg").toString();
    }

    public void setMsg(String msg) {
        this.put("msg",msg);
    }
}
