package com.stylefeng.guns.modular.biz_one.controller.webcontroller;

import com.baomidou.mybatisplus.plugins.Page;
import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.common.constant.factory.PageFactory;
import com.stylefeng.guns.core.util.PageData;
import com.stylefeng.guns.modular.biz_one.service.IPostService;
import com.stylefeng.guns.modular.system.model.Post;
import javafx.geometry.Pos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/w_post")
@ResponseBody
public class WPostController extends BaseController {

    @Autowired
    private IPostService postService;

    @GetMapping("/selectOne/{postId}")
    public PageData selectOne(@PathVariable String postId){
        PageData post = postService.selectOne(postId);
        post.put("additional", "test");
        return post;
    }

    @GetMapping("/list")
    public List<PageData> list(){
        Page<Post> page = new PageFactory<Post>().defaultPage();
        List<PageData> list = postService.selectPosts(page, null);
        return list;
    }


}
