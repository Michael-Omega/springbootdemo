package cn.louiswu.bean;

import java.io.Serializable;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author LouisWu123
 * @since 2019-05-20
 */
public class Role extends Model<Role> {

    private static final long serialVersionUID = 1L;

    @TableId("role_id")
    private Integer roleId;
    @TableField("role_name")
    private String roleName;
    private Date version;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Date getVersion() {
        return version;
    }

    public void setVersion(Date version) {
        this.version = version;
    }

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

    @Override
    public String toString() {
        return "Role{" +
        ", roleId=" + roleId +
        ", roleName=" + roleName +
        ", version=" + version +
        "}";
    }
}
