package cn.louiswu.service.impl;

import cn.louiswu.bean.User;
import cn.louiswu.dao.UserMapper;
import cn.louiswu.service.UserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author LouisWu123
 * @since 2019-05-20
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User getUserByUserName(String userName) {
        User user = userMapper.selectByUsername(userName);
        return user;
    }
}
