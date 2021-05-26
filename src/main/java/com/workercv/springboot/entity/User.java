package com.workercv.springboot.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonProperty("native_place")
    private String nativePlace;
    @JsonProperty("register_time")
    private String registerTime;
    @JsonProperty("active_status")
    private Integer activeStatus;

}
