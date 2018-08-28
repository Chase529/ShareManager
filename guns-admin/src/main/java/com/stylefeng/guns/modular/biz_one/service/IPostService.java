package com.stylefeng.guns.modular.biz_one.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.util.PageData;
import com.stylefeng.guns.modular.system.model.Post;
import com.baomidou.mybatisplus.service.IService;

import java.util.List;

/**
 * <p>
 * 动态发布表 服务类
 * </p>
 *
 * @author Chase
 * @since 2018-08-21
 */
public interface IPostService extends IService<Post> {

    List<PageData> selectPosts(Page<Post>page,String postTitle);

    PageData selectOne(String postId);

}
