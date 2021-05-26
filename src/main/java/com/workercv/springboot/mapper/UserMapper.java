package com.workercv.springboot.mapper;

import com.workercv.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface UserMapper {

    List<User> userLogin(User user);

    int userRegister(User user);

}
