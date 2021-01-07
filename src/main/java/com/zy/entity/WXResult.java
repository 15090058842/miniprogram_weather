package com.zy.entity;

public class WXResult {
    private Integer errcode;
    private String errmsg;
    private Object data;

    public WXResult() {
    }

    public WXResult(Integer errcode, String errmsg, Object data) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.data = data;
    }

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    public static WXResult ok(){
        return new WXResult(0,"成功",null);
    }
    public static WXResult ok(Object data){
        return new WXResult(0,"成功",data);
    }
    public static WXResult fail(){
        return new WXResult(-1,"出错",null);
    }
}
