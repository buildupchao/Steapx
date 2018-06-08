package com.project.steapx.common.util;

import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class JsonUtils {

    /**
     * Convert Java Bean to json string.
     */
    public static String beanToJson(Object data) {
        String str = JSON.toJSONString(data);
        return str;
    }

    public static String beanToJsonWithSilence(Object data) {
        try {
            return beanToJson(data);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Convert json string to Java Bean
     */
    public static <T> T jsonToBean(String jsonData, TypeReference<T> type) {
        T t = JSON.parseObject(jsonData, type);
        return t;
    }

    public static <T> T jsonToBeanWithSilence(String jsonData, TypeReference<T> type) {
        try {
            return jsonToBean(jsonData, type);
        } catch (Exception e) {
        }
        return null;
    }

    public static <T> T jsonToBean(String jsonData, Class<T> cls) {
        T t = JSON.parseObject(jsonData, cls);
        return t;
    }

    public static <T> T jsonToBeanWithSilence(String jsonData, Class<T> cls) {
        try {
            return jsonToBean(jsonData, cls);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Convert json string to bean list
     */
    public static <T> List<T> jsonToBeanList(String jsonData, Class<T> cls) {
        List<T> list = JSON.parseArray(jsonData, cls);
        return list;
    }

    public static <T> List<T> jsonToBeanListWithSilence(String jsonData, Class<T> cls) {
        try {
            return jsonToBeanList(jsonData, cls);
        } catch (Exception e) {
        }
        return null;
    }

    public static <T> List<T> jsonToBeanList(String jsonData, TypeReference<List<T>> type) {
        List<T> list = JSON.parseObject(jsonData, type);
        return list;
    }

    public static <T> List<T> jsonToBeanListWithSilence(String jsonData, TypeReference<List<T>> type) {
        try {
            return jsonToBeanList(jsonData, type);
        } catch (Exception e) {
        }
        return null;
    }

    public static List<String> jsonToStringListWithSilence(String jsonData) {
        try {
            List<String> list = JSON.parseArray(jsonData, String.class);
            return list;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * Convert json string to Map list
     */
    public static List<Map<String, Object>> jsonToMapList(String jsonData) {
        List<Map<String, Object>> list = JSON.parseObject(jsonData,  new TypeReference<List<Map<String,Object>>>(){});
        return list;
    }

    public static List<Map<String, Object>> jsonToMapListWithSilence(String jsonData) {
        try {
            return jsonToMapList(jsonData);
        } catch (Exception e) {
        }
        return null;
    }

}
