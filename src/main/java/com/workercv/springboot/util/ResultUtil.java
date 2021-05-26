package com.workercv.springboot.util;

import java.util.HashMap;

/**
 * 状态码
 * 0->success
 * 1->error
 * @param <T>
 */

public class ResultUtil<T> extends HashMap<String, Object> {

    public static HashMap<Object, Object> success() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", "success");
        return map;
    }

    public static HashMap<Object, Object> success(Integer code) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", "success");
        return map;
    }

    public static HashMap<Object, Object> success(String msg) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", msg);
        return map;
    }

    public static HashMap<Object, Object> success(Integer code, String msg) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

    public static<T> HashMap<Object, Object> success(String msg, T data) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", 0);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    public static<T> HashMap<Object, Object> success(Integer code, String msg, T data) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        map.put("data", data);
        return map;
    }

    public static HashMap<Object, Object> error() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", "error");
        return map;
    }

    public static HashMap<Object, Object> error(Integer code) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", "error");
        return map;
    }

    public static HashMap<Object, Object> error(String msg) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", 1);
        map.put("msg", msg);
        return map;
    }

    public static HashMap<Object, Object> error(Integer code, String msg) {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("code", code);
        map.put("msg", msg);
        return map;
    }

}
