package com.yd.web.service.impl;

import com.yd.web.beans.User;
import com.yd.web.mappers.UserMapper;
import com.yd.web.service.UserService;
import com.yd.web.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private TokenUtils tokenUtils;

    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }

    @Override
    public User loginIn(String username, String pwd) {
        User user = userMapper.loginIn(username, pwd);
        if(user != null){
            user.setToken(tokenUtils.createToken(user.getId()));
        }
        return user;
    }
}
