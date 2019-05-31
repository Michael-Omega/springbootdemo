package cn.louiswu.controller;


import cn.louiswu.bean.User;
import cn.louiswu.service.UserService;
import cn.louiswu.util.JwtUtil;
import cn.louiswu.util.RedisUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

@Component
public class BaseController{

    @Resource
    private UserService userService;
    @Resource
    private RedisUtils redisUtils;
    @Resource
    private JwtUtil jwtUtil;

//    public User getUser(){
//        if (!redisUtils.hasKey("token"))
//            return null;
//        String token = redisUtils.get("token").toString();
//        Map info =  jwtUtil.validateToken(token);
//        return userService.getUserByUserName(info.get("username").toString());
//    }
}
