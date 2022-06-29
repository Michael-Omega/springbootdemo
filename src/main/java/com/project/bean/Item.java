package com.project.bean;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 商品表
    */
@ApiModel(value="cn-louiswu-bean-Item")
@Data
@TableName(value = "item")
public class Item implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    @ApiModelProperty(value="")
    private Integer id;

    /**
     * 公司id
     */
    @TableField(value = "companyid")
    @ApiModelProperty(value="公司id")
    private Integer companyid;

    /**
     * 店铺id
     */
    @TableField(value = "platformid")
    @ApiModelProperty(value="店铺id")
    private Integer platformid;

    /**
     * 商品编码
     */
    @TableField(value = "code")
    @ApiModelProperty(value="商品编码")
    private String code;

    /**
     * 线程编号
     */
    @TableField(value = "syncnum")
    @ApiModelProperty(value="线程编号")
    private Integer syncnum;

    /**
     * 同步状态，0是未同步 1是已同步
     */
    @TableField(value = "syncstate")
    @ApiModelProperty(value="同步状态，0是未同步 1是已同步")
    private Integer syncstate;

    /**
     * 同步时间
     */
    @TableField(value = "synctime")
    @ApiModelProperty(value="同步时间")
    private Date synctime;

    /**
     * 平台的商品id(天猫用)
     */
    @TableField(value = "productid")
    @ApiModelProperty(value="平台的商品id(天猫用)")
    private Long productid;

    /**
     * 商品的skuid
     */
    @TableField(value = "skuid")
    @ApiModelProperty(value="商品的skuid")
    private String skuid;

    /**
     * 商品名称
     */
    @TableField(value = "name")
    @ApiModelProperty(value="商品名称")
    private String name;

    private static final long serialVersionUID = 1L;
}