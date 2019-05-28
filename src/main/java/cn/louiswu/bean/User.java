package cn.louiswu.bean;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;


/**
 * <p>
 * 
 * </p>
 *
 * @author LouisWu123
 * @since 2019-05-21
 */
public class User extends Model<User> {

    private static final long serialVersionUIDLONG = 1L;

    /**
     * 用户主键
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户名
     */
    @TableField("user_name")
    private String userName;
    /**
     * 用户密码
     */
    @TableField("user_pwd")
    private String userPwd;
    /**
     * 版本号
     */
    private Date version;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "User{" +
        ", userId=" + userId +
        ", userName=" + userName +
        ", userPwd=" + userPwd +
        ", version=" + version +
        "}";
    }
}
