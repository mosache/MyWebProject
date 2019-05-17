package com.yd.web.controller;

import com.yd.web.beans.ResponseEntry;
import com.yd.web.beans.User;
import com.yd.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /***
     * 根据ID获取用户
     */
    @GetMapping("/getUser/{id}")
    public ResponseEntry<User> getUser(@PathVariable("id") Integer id){
        User user = userService.getUserById(id);
        ResponseEntry<User> resp = new ResponseEntry<>();
        resp.setState(2);
        resp.setMsg("");
        resp.setData(user);
        return resp;
    }
}
