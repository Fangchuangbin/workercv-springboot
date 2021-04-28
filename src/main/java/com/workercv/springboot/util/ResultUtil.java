package com.workercv.springboot.util;

import com.workercv.springboot.vo.ResultVO;

public class ResultUtil {
    public static<T> ResultVO<T> success() {
        return ResultData(20000, "success", null);
    }

    public static<T> ResultVO<T> success(T data) {
        return ResultData(20000, "success", data);
    }

    public static<T> ResultVO<T> fail() {
        return ResultData(40000, "fail", null);
    }

    public static<T> ResultVO<T> ResultData(Integer code, String msg, T data) {
        ResultVO<T> resultVO = new ResultVO<>();
        resultVO.setCode(code);
        resultVO.setMsg(msg);
        resultVO.setData(data);
        return resultVO;
    }
}
