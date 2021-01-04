package com.sm.cn.vo;

import java.util.Hashtable;

public class ResultJson extends Hashtable<String,Object> {

    private final static String STATUS="status";
    private final static String MSG="msg";
    private final static String DATA="data";

    private ResultJson() {
    }

    private ResultJson(ResultStatus status) {
        this.put(STATUS,status.getStatus());
        this.put(MSG,status.getMsg());
    }

    /**
     * 返回统一成功，不携带数据
     */
    public static ResultJson success(){
        return new ResultJson(ResultStatus.SUCCESS);
    }

    /**
     * 返回统一成功，携带数据
     */
    public static ResultJson success(Object obj){
        ResultJson resultJson = success();
        resultJson.put(DATA,obj);
        return resultJson;
    }

    /**
     * 调用有参构造
     * 返回自定义状态码，不携带数据
     */
    public static ResultJson success(ResultStatus status){
        return new ResultJson(status);
    }

    /**
     * 返回自定义状态码，携带数据
     */
    public static ResultJson success(ResultStatus status,Object obj){
        ResultJson success = success(status);
        success.put(DATA,obj);
        return success;
    }

    /**
     * 返回统一失败，不携带数据
     */
    public static ResultJson erorr(){
        return new ResultJson(ResultStatus.ERROR);
    }

    /**
     * 返回统一失败，携带数据
     */
    public static ResultJson erorr(Object obj){
        ResultJson erorr = erorr();
        erorr.put(DATA,obj);
        return erorr;
    }

    /**
     * 返回自定义失败，不携带数据
     */
    public static ResultJson erorr(ResultStatus status){
        return new ResultJson(status);
    }

    /**
     * 返回自定义失败，携带数据
     */

    public static ResultJson erorr(ResultStatus status,Object obj){
        ResultJson erorr = erorr(status);
        erorr.put(DATA,obj);
        return erorr;
    }
}
