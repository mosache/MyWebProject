package com.yd.web.mappers;

import com.yd.web.beans.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    User getUserById(Integer id);
}
