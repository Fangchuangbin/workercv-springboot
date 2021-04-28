package com.workercv.springboot.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

    private String uuid;
    private String phone;
    private String email;
    private String password;
    private String realname;
    private String nickname;
    private Integer sex;
    private String avatar;
    private String nativePlace;
    private Integer registerTime;

}
