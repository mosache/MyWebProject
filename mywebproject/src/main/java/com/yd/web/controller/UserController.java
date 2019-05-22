package com.yd.web.controller;

import com.yd.web.annotations.YDRequest;
import com.yd.web.beans.ResponseEntry;
import com.yd.web.beans.User;
import com.yd.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /***
     * 根据ID获取用户
     */
    @YDRequest(path = "/getUser")
    public ResponseEntry<User> getUser(@RequestParam ("id") Integer id) {
        User user = userService.getUserById(id);
        ResponseEntry<User> resp = new ResponseEntry<>();
        resp.setData(user);
        return resp;
    }

    @YDRequest(path = "/loginIn")
    public ResponseEntry<User> loginIn(
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        User user = userService.loginIn(username, password);
        if (user == null){
            ResponseEntry<User> resp = new ResponseEntry<>();
            resp.setMsg("用户名或密码错误！");
            return resp;
        }
        return new ResponseEntry(1,"",user);
    }
}
