package com.workercv.springboot.controller;

import com.auth0.jwt.exceptions.SignatureVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.sun.org.glassfish.gmbal.ParameterNames;
import com.workercv.springboot.entity.User;
import com.workercv.springboot.service.UserService;
import com.workercv.springboot.util.JWTUtil;
import com.workercv.springboot.util.ResultUtil;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@CrossOrigin
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/api/user/login")
    public Object userLogin(@RequestBody User user) {
        if(user.getPhone().equals("") || user.getPassword().equals("")) {
            return ResultUtil.error("请填写完整信息");
        }else{
            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
            List<User> userLogin = userService.userLogin(user);
            HashMap<String, String> loginMap = new HashMap<>();
            loginMap.put("phone", userLogin.get(0).getPhone());
            loginMap.put("realname", userLogin.get(0).getRealname());
            Base64 encoder = new Base64();
            byte[] token = JWTUtil.generateToken(loginMap).getBytes();
            String resultToken = encoder.encodeToString(token);
            System.out.println(resultToken);
            if(userLogin.isEmpty()) {
                return ResultUtil.error("用户不存在");
            }else if(user.getPassword().equals(userLogin.get(0).getPassword())){
                HashMap<Object, Object> resultMap = new HashMap<>();
                resultMap.put("token", resultToken);
                resultMap.put("info", userLogin.get(0));
                return ResultUtil.success("登录成功", resultMap);
            }else{
                return ResultUtil.error("账号或密码错误");
            }
        }
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("test");
    }

    @PostMapping("/api/user/register")
    public Object userRegister(@RequestBody User user) {
        if(user.getPhone().equals("") || user.getEmail().equals("") || user.getPassword().equals("") || user.getRealname().equals("")) {
            return ResultUtil.error("请填写完整信息");
        }else{
            List<User> userLogin = userService.userLogin(user);
            if(userLogin.isEmpty()) {
                user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
                user.setUuid(UUID.randomUUID().toString().replace("-", "").toLowerCase());
                user.setRegisterTime(String.valueOf(System.currentTimeMillis()));
                user.setActiveStatus(0);
                int userRegister = userService.userRegister(user);
                if(userRegister == 1) {
                    return ResultUtil.success("注册成功");
                }else{
                    return ResultUtil.error("注册失败");
                }
            }else{
                return ResultUtil.error(2,"用户已存在");
            }

        }
    }

}
