package com.workercv.springboot.service;

import com.workercv.springboot.dto.UserLoginDTO;
import com.workercv.springboot.dto.UserRegisterDTO;
import com.workercv.springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> userLogin(UserLoginDTO userLoginDTO);

    int userRegister(UserRegisterDTO userRegisterDTO);

}
