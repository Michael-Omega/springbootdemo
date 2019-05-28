package cn.louiswu.controller;

import cn.louiswu.bean.result.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/test")
public class TestController extends BaseController{
    public static final Logger logger = LoggerFactory.getLogger(TestController.class);
    @RequestMapping("/get")
    public Result test( String username,String password){
        Result result = new Result();
        try{
            result.setCode(1);
            result.setMsg("成功");
            Map<Object,Object> maps = new HashMap();
            maps.put("username",username);
            maps.put("password",password);
            result.setObj(maps);
        }catch (Exception e){
            logger.error("登录失败{}",e);
        }
        return result;
    }
}
