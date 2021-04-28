package com.workercv.springboot.controller;

import com.workercv.springboot.dto.UserLoginDTO;
import com.workercv.springboot.dto.UserRegisterDTO;
import com.workercv.springboot.entity.User;
import com.workercv.springboot.service.UserService;
import com.workercv.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/loginForm")
    public Object userLogin(@RequestBody UserLoginDTO userLoginDTO) {
        if(userLoginDTO.getPhone().equals("") || userLoginDTO.getPassword().equals("")) {
            return ResultUtil.fail();
        }else{
            userLoginDTO.setPassword(DigestUtils.md5DigestAsHex(userLoginDTO.getPassword().getBytes()));
            List<User> userLogin = userService.userLogin(userLoginDTO);
            if(userLogin.size() != 0){
                return ResultUtil.success(userLogin.get(0));
            }else{
                return ResultUtil.success(userLogin);
            }

        }
    }

    @PostMapping("/registerUser")
    public Object userRegister(@RequestBody UserRegisterDTO userRegisterDTO) {


        // return UUID.randomUUID().toString().replace("-", "").toLowerCase();
        return null;
    }

}
