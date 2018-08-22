package com.stylefeng.guns.modular.system.model;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 动态发布表
 * </p>
 *
 * @author Chase
 * @since 2018-08-21
 */
@TableName("tbl_post")
public class Post extends Model<Post> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(type=IdType.UUID, value = "post_id")
    private String postId;
    /**
     * post标题
     */
    @TableField("post_title")
    private String postTitle;
    /**
     * post简介
     */
    @TableField("post_short")
    private String postShort;
    /**
     * post的故事，可选添加
     */
    @TableField("post_story")
    private String postStory;
    /**
     * 1可见 2不可见
     */
    @TableField("is_show")
    private Integer isShow;
    /**
     * 点击量
     */
    @TableField("click_count")
    private Integer clickCount;
    /**
     * 喜欢数量
     */
    @TableField("like_count")
    private Integer likeCount;
    /**
     * 发布人id
     */
    @TableField("post_uid")
    private String postUid;
    /**
     * 发布时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;


    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostTitle() {
        return postTitle;
    }

    public void setPostTitle(String postTitle) {
        this.postTitle = postTitle;
    }

    public String getPostShort() {
        return postShort;
    }

    public void setPostShort(String postShort) {
        this.postShort = postShort;
    }

    public String getPostStory() {
        return postStory;
    }

    public void setPostStory(String postStory) {
        this.postStory = postStory;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getClickCount() {
        return clickCount;
    }

    public void setClickCount(Integer clickCount) {
        this.clickCount = clickCount;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    public String getPostUid() {
        return postUid;
    }

    public void setPostUid(String postUid) {
        this.postUid = postUid;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    protected Serializable pkVal() {
        return this.postId;
    }

    @Override
    public String toString() {
        return "Post{" +
        "postId=" + postId +
        ", postTitle=" + postTitle +
        ", postShort=" + postShort +
        ", postStory=" + postStory +
        ", isShow=" + isShow +
        ", clickCount=" + clickCount +
        ", likeCount=" + likeCount +
        ", postUid=" + postUid +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        "}";
    }
}
