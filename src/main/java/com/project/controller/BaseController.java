package com.project.controller;


//import cn.louiswu.util.JwtUtil;
import com.project.util.RedisUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BaseController{

    @Resource
    private RedisUtils redisUtils;
//    @Resource
//    private JwtUtil jwtUtil;

//    public User getUser(){
//        if (!redisUtils.hasKey("token"))
//            return null;
//        String token = redisUtils.get("token").toString();
//        Map info =  jwtUtil.validateToken(token);
//        return userService.getUserByUserName(info.get("username").toString());
//    }
}
