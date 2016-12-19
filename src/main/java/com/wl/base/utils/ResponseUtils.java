package com.wl.base.utils;

import com.alibaba.fastjson.JSONObject;

/**
 * 返回值处理工具
 *
 * @author wangliang
 */
public class ResponseUtils {
    public static JSONObject generSuccJson(JSONObject data) {
        JSONObject json = new JSONObject();
        json.put("code", 0);
        json.put("msg", "");
        json.put("data", data);

        return json;
    }

    public static String generSuccJsonStr(JSONObject data) {
        return generSuccJson(data).toJSONString();
    }


    public static JSONObject generFailedJson(int code, String error) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("msg", error);
        return json;
    }

    public static String generFailedJsonStr(int code, String error) {
        return generFailedJson(code, error).toJSONString();
    }

}
