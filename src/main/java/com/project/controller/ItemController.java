package com.project.controller;

import com.project.bean.result.Result;
import com.project.service.ItemService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.project.util.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("item")
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private RedisUtils redisUtils;

    @RequestMapping("list")
    public Result list(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.last("limit 50");
        List list = itemService.list(queryWrapper);
        return Result.success(list);
    }

    @RequestMapping("put")
    public Result put(){
        redisUtils.set("a","b");
        return Result.success();
    }

    @RequestMapping("get")
    public Result get(){
        return Result.success(redisUtils.get("a"));
    }


}
