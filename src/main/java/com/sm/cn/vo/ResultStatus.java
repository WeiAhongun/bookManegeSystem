package com.sm.cn.vo;

public enum ResultStatus {
    SUCCESS("20000","操作成功"),
    ERROR("20001","操作失败"),
    USERNAME_OR_PASSWOED_ERROR("20002","用户名或密码错误"),
    LOGIN_ERROR("20003","用户未登入"),
    GLOBAL_ERROR("20004","错误")
    ;

    private String status;
    private String msg;

    ResultStatus(String status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
