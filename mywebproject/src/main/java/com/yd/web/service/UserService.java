package com.yd.web.service;

import com.yd.web.beans.User;

public interface UserService {

    User getUserById(Integer id);

    User loginIn(String username,String pwd);

}
