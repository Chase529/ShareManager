package com.stylefeng.guns.modular.biz_one.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.util.PageData;
import com.stylefeng.guns.core.util.UuidUtil;
import com.stylefeng.guns.modular.system.warpper.biz_one.PostWarpper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.Post;
import com.stylefeng.guns.modular.biz_one.service.IPostService;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * 发布动态管理控制器
 *
 * @author fengshuonan
 * @Date 2018-08-21 15:14:08
 */
@Controller
@RequestMapping("/post")
public class PostController extends BaseController {

    private String PREFIX = "/biz_one/post/";

    @Autowired
    private IPostService postService;

    /**
     * 跳转到发布动态管理首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "post.html";
    }

    /**
     * 跳转到添加发布动态管理
     */
    @RequestMapping("/post_add")
    public String postAdd() {
        return PREFIX + "post_add.html";
    }

    /**
     * 跳转到修改发布动态管理
     */
    @RequestMapping("/post_update/{postId}")
    public String postUpdate(@PathVariable String postId, Model model) {
        Post post = postService.selectById(postId);
        model.addAttribute("item",post);
        LogObjectHolder.me().set(post);
        return PREFIX + "post_edit.html";
    }

    /**
     * 获取发布动态管理列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        Page<Post> page = new Page<>();
        List<PageData> postList = postService.selectPosts(page,null);
        List<PageData> list = (List<PageData>) new PostWarpper(postList).warp();

        return list;
    }

    /**
     * 新增发布动态管理
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Post post, MultipartFile[] files) {
        post.setPostId(UuidUtil.get32Uuid());
        System.out.println(files.length);
        postService.insert(post);
        return SUCCESS_TIP;
    }

    /**
     * 删除发布动态管理
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String postId) {
        postService.deleteById(postId);
        return SUCCESS_TIP;
    }

    /**
     * 修改发布动态管理
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Post post) {
        postService.updateById(post);
        return SUCCESS_TIP;
    }

    /**
     * 发布动态管理详情
     */
    @RequestMapping(value = "/detail/{postId}")
    @ResponseBody
    public Object detail(@PathVariable("postId") Integer postId) {
        return postService.selectById(postId);
    }
}
