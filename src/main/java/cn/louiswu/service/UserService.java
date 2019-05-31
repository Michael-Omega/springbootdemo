package cn.louiswu.service;

import cn.louiswu.bean.User;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;


/**
 * <p>
 *  服务类
 * </p>
 *
 * @author LouisWu123
 * @since 2019-05-20
 */
public interface UserService extends IService<User> {

    User getUserByUserName(String UserName);



}
