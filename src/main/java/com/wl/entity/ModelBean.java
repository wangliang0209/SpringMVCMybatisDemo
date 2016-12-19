package com.wl.entity;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.wl.base.common.Constants;

/**
 * 自定义接口返回信息对象
 */
public class ModelBean extends JSONObject {
    private static final long serialVersionUID = -5754814579884800211L;
    private int code;//0:成功/1:失败
    private String msg;//接口信息
    private Object data;//返回数据

    protected void init() {
        this.put("code", this.code);
        if (this.msg != null && this.msg.length() > 0) {
            this.put("msg", this.msg);
        }
        if (this.data != null) {
            this.put("data", this.data);
        }
    }

    public ModelBean() {
        this.code = Constants.STATUS_SUCCESS;
        this.msg = "";
        init();
    }


    /**
     * 创建一个新的实例 ModelBean.
     *
     * @param code 状态码
     * @param msg  接口信息
     */
    public ModelBean(int code, String msg) {
        this.code = code;
        this.msg = msg;
        init();
    }

    /**
     * 创建一个新的实例 ModelBean.
     *
     * @param data 返回数据
     */
    public ModelBean(Object data) {
        this();
        this.data = data;
        init();
    }

    public ModelBean(JSONObject data) {
        this();
        this.data = JSON.parseObject(data.toJSONString());
        init();
    }

    /**
     * 结果是否成功
     *
     * @return
     */
    public boolean isSuccess() {
        return this.code == Constants.STATUS_SUCCESS;
    }

    /**
     * 是否错误
     *
     * @return
     */
    public boolean isError() {
        return this.code == Constants.STATUS_ERROR;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return this.toJSONString();
    }
}
