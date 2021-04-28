package com.workercv.springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserLoginDTO implements Serializable {

    private String phone;
    private String password;

}
