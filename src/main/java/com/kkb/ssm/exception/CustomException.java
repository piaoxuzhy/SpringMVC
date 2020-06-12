package com.kkb.ssm.exception;

public class CustomException extends Exception {
    private static final long serialVersionUID = 1L;

    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public CustomException(String msg) {
        super();
        this.msg = msg;
    }
}
