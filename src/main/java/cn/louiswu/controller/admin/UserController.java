package cn.louiswu.controller.admin;


import cn.louiswu.bean.User;
import cn.louiswu.bean.result.Result;
import cn.louiswu.service.UserService;
import cn.louiswu.util.JwtUtil;
import cn.louiswu.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    @Resource
    private RedisUtils redisUtils;


    @PostMapping("/login")
    public Result login(User userParams){
        Result result = new Result();
        User user = isValidPassword(userParams);
        if(null != user){
            String jwt = jwtUtil.generateToken(userParams.getUserName());
            System.out.println("jwt="+jwt);
            result.setCode(1);
            result.setMsg("成功");
            //将JWTtoken存入redis
            redisUtils.set("token","Bearer "+jwt,7200L);
            Map<Object,Object> datas = new HashMap<>();
            datas.put("jwt",jwt);
            datas.put("user",user);
            result.setObj(datas);
        }else {
            result.setCode(0);
            result.setMsg("失败");
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

    @PostMapping("/getToken")
    public Result getToken(){
        Result result = new Result();
        try {
            System.err.println(redisUtils.hasKey("token"));
            String token = (String) redisUtils.get("token");
            Map<String, Object> data = jwtUtil.validateToken(token);
            result.setCode(1);
            result.setMsg("成功");
            result.setObj(data);
        } catch (Exception e) {
            result.setCode(0);
            result.setMsg("失败");
            logger.error("获取失败{}",e);
        }
        return  result;
    }

    @RequestMapping("logout")
    public Result Logout(){
        Result result = new Result();
        try {

            redisUtils.del("token");
            result.setCode(1);
            result.setMsg("退出成功");
        } catch (Exception e) {
            result.setCode(0);
            result.setMsg(e.getMessage());
            logger.error("退出登录失败{}",e);
        }
        return result;

    }

    @RequestMapping("/getUser")
    public Result getUserInfo(){
        Result result = new Result();
        try {
            result.setObj(1);
            result.setMsg("成功");
            result.setObj(getUser());
        }catch (Exception e){
            result.setObj(0);
            result.setMsg("失败");
        }
        return result;
    }

}

