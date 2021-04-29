package com.workercv.springboot.common;

import lombok.Getter;

@Getter
public enum CodeEnum {

    SUCCESS(20000),
    USER_NULL(20001),
    ERROR(40000);

    private final Integer code;

    CodeEnum(Integer code) {
        this.code = code;
    }
}
