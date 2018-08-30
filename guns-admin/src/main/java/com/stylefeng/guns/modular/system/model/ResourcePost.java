package com.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 动态发布资源表
 * </p>
 *
 * @author Chase
 * @since 2018-08-30
 */
@TableName("tbl_resource_post")
public class ResourcePost extends Model<ResourcePost> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId("res_id")
    private String resId;
    /**
     * 资源地址
     */
    @TableField("res_url")
    private String resUrl;
    /**
     * 1图片 2视频 3其他
     */
    @TableField("res_type")
    private Integer resType;
    /**
     * 描述
     */
    @TableField("res_desc")
    private String resDesc;
    /**
     * 关联id
     */
    @TableField("relation_id")
    private String relationId;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;


    public String getResId() {
        return resId;
    }

    public void setResId(String resId) {
        this.resId = resId;
    }

    public String getResUrl() {
        return resUrl;
    }

    public void setResUrl(String resUrl) {
        this.resUrl = resUrl;
    }

    public Integer getResType() {
        return resType;
    }

    public void setResType(Integer resType) {
        this.resType = resType;
    }

    public String getResDesc() {
        return resDesc;
    }

    public void setResDesc(String resDesc) {
        this.resDesc = resDesc;
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.resId;
    }

    @Override
    public String toString() {
        return "ResourcePost{" +
        "resId=" + resId +
        ", resUrl=" + resUrl +
        ", resType=" + resType +
        ", resDesc=" + resDesc +
        ", relationId=" + relationId +
        ", createTime=" + createTime +
        "}";
    }
}
