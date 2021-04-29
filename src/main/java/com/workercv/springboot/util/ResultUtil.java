package com.workercv.springboot.util;

import com.workercv.springboot.common.CodeEnum;
import com.workercv.springboot.vo.ResultVO;

public class ResultUtil {

    public static<T> ResultVO<T> success() {
        return ResultData(CodeEnum.SUCCESS.getCode(), "success", null);
    }

    public static<T> ResultVO<T> success(String msg) {
        return ResultData(20000, msg, null);
    }

    public static<T> ResultVO<T> success(T data) {
        return ResultData(20000, "success", data);
    }

    public static<T> ResultVO<T> success(String msg, T data) {
        return ResultData(20000, msg, data);
    }

    public static<T> ResultVO<T> success(Integer code, String msg, T data) {
        return ResultData(code, msg, data);
    }

    public static<T> ResultVO<T> error() {
        return ResultData(40000, "fail", null);
    }

    public static<T> ResultVO<T> error(String msg) {
        return ResultData(40000, msg, null);
    }

    public static<T> ResultVO<T> error(T data) {
        return ResultData(40000, "fail", data);
    }

    public static<T> ResultVO<T> error(String msg, T data) {
        return ResultData(40000, msg, data);
    }

    public static<T> ResultVO<T> error(Integer code, String msg, T data) {
        return ResultData(code, msg, data);
    }

    public static<T> ResultVO<T> ResultData(Integer code, String msg, T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(data);
        return resultVO;
    }
}
