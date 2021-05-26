package com.workercv.springboot.service;

import com.workercv.springboot.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<User> userLogin(User user);

    int userRegister(User user);

}
