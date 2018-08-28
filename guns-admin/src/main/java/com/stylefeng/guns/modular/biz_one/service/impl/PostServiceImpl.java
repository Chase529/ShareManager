package com.stylefeng.guns.modular.biz_one.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.util.PageData;
import com.stylefeng.guns.modular.system.model.Post;
import com.stylefeng.guns.modular.system.dao.PostMapper;
import com.stylefeng.guns.modular.biz_one.service.IPostService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 动态发布表 服务实现类
 * </p>
 *
 * @author Chase
 * @since 2018-08-21
 */
@Service
public class PostServiceImpl extends ServiceImpl<PostMapper, Post> implements IPostService {


    @Override
    public List<PageData> selectPosts(Page<Post> page,String postTitle) {
        return this.baseMapper.selectPosts(page,postTitle);
    }

    @Override
    public PageData selectOne(String postId) {
        return this.baseMapper.selectById(postId);
    }
}
