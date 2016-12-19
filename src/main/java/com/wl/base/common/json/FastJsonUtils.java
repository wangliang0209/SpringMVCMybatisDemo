package com.wl.base.common.json;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.wl.base.exception.GlobalException;

import java.util.List;
import java.util.Map;

@SuppressWarnings({"rawtypes", "hiding"})
public class FastJsonUtils {

    /**
     * 功能描述：把JSON数据转换成普通字符串列表
     *
     * @param jsonData JSON数据
     * @return
     * @throws Exception
     */
    public static List<String> getStringList(String jsonData) throws GlobalException {
        return JSON.parseArray(jsonData, String.class);
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象
     *
     * @param jsonData JSON数据
     * @param clazz    指定的java对象
     * @return
     * @throws Exception
     */
    public static <T> T getSingleBean(String jsonData, Class<T> clazz) throws GlobalException {
        return JSON.parseObject(jsonData, clazz);
    }

    /**
     * 功能描述：把JSON数据转换成指定的java对象列表
     *
     * @param jsonData JSON数据
     * @param clazz    指定的java对象
     * @return
     * @throws Exception
     */
    public static <T> List<T> getBeanList(String jsonData, Class<T> clazz) throws GlobalException {
        return JSON.parseArray(jsonData, clazz);
    }

    /**
     * 功能描述：把JSON数据转换成较为复杂的java对象列表
     *
     * @param jsonData JSON数据
     * @return
     * @throws Exception
     */
    public static List<Map<String, Object>> getBeanMapList(String jsonData) throws GlobalException {
        return JSON.parseObject(jsonData, new TypeReference<List<Map<String, Object>>>() {
        });
    }

    /**
     * 将网络请求下来的数据用fastjson处理空的情况，并将时间戳转化为标准时间格式
     *
     * @param result
     * @return
     */
    @SuppressWarnings("deprecation")
    public static String dealResponseResult(String result) {
        result = JSONObject.toJSONString(result,
                SerializerFeature.WriteClassName,
                SerializerFeature.WriteMapNullValue,
                SerializerFeature.WriteNullBooleanAsFalse,
                SerializerFeature.WriteNullListAsEmpty,
                SerializerFeature.WriteNullNumberAsZero,
                SerializerFeature.WriteNullStringAsEmpty,
                SerializerFeature.WriteDateUseDateFormat,
                SerializerFeature.WriteEnumUsingToString,
                SerializerFeature.WriteSlashAsSpecial,
                SerializerFeature.WriteTabAsSpecial);
        return result;
    }

    /**
     * map2Json(将Map转json字符串)
     *
     * @param map 待传map
     * @return String        json字符串
     * @author 张本学
     * @since 1.0.0
     */
    public static String map2Json(Map map) {
        String s = JSONObject.toJSONString(map);
        return s;
    }

    /**
     * map2Json(将Map转json字符串)
     *
     * @param object 对象
     * @return String        json字符串
     * @author hengjun.ge
     * @since 1.0.0
     */
    public static String object2Json(Object object) {
        String s = JSONObject.toJSONString(object);
        return s;
    }

    /**
     * json2Map(将Json转Map)
     *
     * @param jsonStr 待转json字符串
     * @return Map<String,Object> Map
     * @author 张本学
     * @since 1.0.0
     */
    public static Map json2Map(String jsonStr) {
        Map m = JSONObject.parseObject(jsonStr);
        return m;
    }

}
