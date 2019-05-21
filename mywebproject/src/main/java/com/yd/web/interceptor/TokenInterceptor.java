package com.yd.web.interceptor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.yd.web.beans.ResponseEntry;
import com.yd.web.utils.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TokenInterceptor implements HandlerInterceptor{

    @Autowired
    TokenUtils tokenUtils;

    @Autowired
    ObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{

        String token = request.getParameter("token");

        if(token == null){
            ResponseEntry resp = new ResponseEntry();
            resp.setState(0);
            resp.setMsg("token is NULL!");
            response.setStatus(503);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(resp));
        }else {
            return tokenUtils.isValidToken(token,null);
        }
        return false;
    }
}
