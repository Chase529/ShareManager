package com.stylefeng.guns.modular.system.dao;

import com.stylefeng.guns.core.datascope.DataScope;
import com.stylefeng.guns.core.util.PageData;
import com.stylefeng.guns.modular.system.model.Post;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * 动态发布表 Mapper 接口
 * </p>
 *
 * @author Chase
 * @since 2018-08-21
 */
public interface PostMapper extends BaseMapper<Post> {

    /**
     * 根据条件查询用户列表
     */
    List<PageData> selectPosts(@Param("postTitle") String postTitle);

    /**
     * 根据id查询
     */
    PageData selectById(@Param("postId") String postId);

}
