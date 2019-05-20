package com.yd.web.controller;

import com.yd.web.beans.ResponseEntry;
import com.yd.web.beans.User;
import com.yd.web.service.UserService;
import com.yd.web.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    /***
     * 根据ID获取用户
     */
    @GetMapping("/getUser/{id}")
    public ResponseEntry<User> getUser(@PathVariable("id") Integer id) {
        User user = userService.getUserById(id);
        ResponseEntry<User> resp = new ResponseEntry<>();
        resp.setData(user);
        return resp;
    }

    @RequestMapping(path = "/loginIn",method = {RequestMethod.POST,RequestMethod.GET})
    public ResponseEntry<User> loginIn(
            @RequestParam("username") String username,
            @RequestParam("password") String password){
        User user = userService.loginIn(username, password);
        if (user == null){
            ResponseEntry<User> resp = new ResponseEntry<>();
            resp.setState(0);
            resp.setMsg("用户名或密码错误！");
            return resp;
        }
        return new ResponseEntry<User>(0,"",user);
    }
}
