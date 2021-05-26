package com.workercv.springboot.service.impl;

import com.workercv.springboot.entity.User;
import com.workercv.springboot.mapper.UserMapper;
import com.workercv.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper userMapper;

    @Override
    public List<User> userLogin(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public int userRegister(User user) {
        return userMapper.userRegister((user));
    }

}
