package com.workercv.springboot.controller;

import com.workercv.springboot.dto.UserLoginDTO;
import com.workercv.springboot.dto.UserRegisterDTO;
import com.workercv.springboot.entity.User;
import com.workercv.springboot.service.UserService;
import com.workercv.springboot.util.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import java.util.List;
import java.util.UUID;

@RestController
public class UserController implements WebMvcConfigurer {

    @Autowired
    UserService userService;

    @PostMapping("/api/user/login")
    @CrossOrigin("http://192.168.99.14:3000")
    public Object userLogin(@RequestBody UserLoginDTO userLoginDTO) {
        if(userLoginDTO.getPhone().equals("") || userLoginDTO.getPassword().equals("")) {
            return ResultUtil.error("请填写完整信息");
        }else{
            userLoginDTO.setPassword(DigestUtils.md5DigestAsHex(userLoginDTO.getPassword().getBytes()));
            List<User> userLogin = userService.userLogin(userLoginDTO);
            if(userLogin.size() != 0){
                return ResultUtil.success(userLogin.get(0));
            }else{
                return ResultUtil.error("账号或密码错误");
            }
        }
    }

    @PostMapping("/api/user/register")
    public Object userRegister(@RequestBody UserRegisterDTO userRegisterDTO) {
        if(userRegisterDTO.getPhone().equals("") || userRegisterDTO.getEmail().equals("") || userRegisterDTO.getPassword().equals("") || userRegisterDTO.getRealname().equals("") || userRegisterDTO.getNickname().equals("") || userRegisterDTO.getSex().toString().equals("") || userRegisterDTO.getAvatar().equals("") ) {
            return ResultUtil.error("请填写完整信息");
        }
        userRegisterDTO.setPassword(DigestUtils.md5DigestAsHex(userRegisterDTO.getPassword().getBytes()));
        userRegisterDTO.setUuid(UUID.randomUUID().toString().replace("-", "").toLowerCase());
        userRegisterDTO.setRegisterTime(String.valueOf(System.currentTimeMillis()));
        int userRegister = userService.userRegister(userRegisterDTO);
        if(userRegister == 1) {
            return ResultUtil.success("注册用户成功");
        }else{
            return ResultUtil.error();
        }
    }

}
