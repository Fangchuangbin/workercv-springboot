package com.workercv.springboot.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserRegisterDTO implements Serializable {

    private String phone;
    private String email;
    private String password;
    private String realname;
    private String nickname;
    private Integer sex;
    private String avatar;
    private String nativePlace;

}
