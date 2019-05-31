package cn.louiswu.controller.admin;


import cn.louiswu.bean.User;
import cn.louiswu.bean.result.Result;
import cn.louiswu.config.anno.PassToken;
import cn.louiswu.config.anno.UserLoginToken;
import cn.louiswu.service.UserService;
import cn.louiswu.util.JwtUtil;
import cn.louiswu.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.louiswu.controller.BaseController;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author LouisWu123
 * @since 2019-05-20
 */
@RestController
@RequestMapping("/user")
public class UserController extends BaseController {

    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;
    @Resource
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public Result Login(User userParams){
        Result result = new Result();
        User user = isValidPassword(userParams);
        if (null == user){
            result.setCode(0);
            result.setMsg("用户名或者密码错误");
        }else {
            result.setCode(1);
            result.setMsg("登录成功");
            Map data = new HashMap();
            data.put("user",user);
            data.put("token",jwtUtil.getToken(user));
            result.setObj(data);
        }
        return result;
    }


    public User isValidPassword(User userParams){
        User user =  userService.getUserByUserName(userParams.getUserName());
        if ( null!=user && user.getUserPwd().trim()==user.getUserPwd().trim()){
            return user;
        }
        return null;
    }


    @RequestMapping("/getMessage")
    @UserLoginToken
    public String getMessage(){
        return "你已通过验证";
    }
}

