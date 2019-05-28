package cn.louiswu.dao;

import cn.louiswu.bean.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author LouisWu123
 * @since 2019-05-20
 */
public interface UserMapper extends BaseMapper<User> {

    User selectByUsername(String userName);
}
