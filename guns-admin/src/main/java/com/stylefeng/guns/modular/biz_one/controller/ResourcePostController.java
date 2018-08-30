package com.stylefeng.guns.modular.biz_one.controller;

import com.stylefeng.guns.core.base.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;
import com.stylefeng.guns.core.log.LogObjectHolder;
import org.springframework.web.bind.annotation.RequestParam;
import com.stylefeng.guns.modular.system.model.ResourcePost;
import com.stylefeng.guns.modular.biz_one.service.IResourcePostService;

/**
 * 动态资源表控制器
 *
 * @author fengshuonan
 * @Date 2018-08-30 09:51:25
 */
@Controller
@RequestMapping("/resourcePost")
public class ResourcePostController extends BaseController {

    private String PREFIX = "/biz_one/resourcePost/";

    @Autowired
    private IResourcePostService resourcePostService;

    /**
     * 跳转到动态资源表首页
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "resourcePost.html";
    }

    /**
     * 跳转到添加动态资源表
     */
    @RequestMapping("/resourcePost_add")
    public String resourcePostAdd() {
        return PREFIX + "resourcePost_add.html";
    }

    /**
     * 跳转到修改动态资源表
     */
    @RequestMapping("/resourcePost_update/{resourcePostId}")
    public String resourcePostUpdate(@PathVariable Integer resourcePostId, Model model) {
        ResourcePost resourcePost = resourcePostService.selectById(resourcePostId);
        model.addAttribute("item",resourcePost);
        LogObjectHolder.me().set(resourcePost);
        return PREFIX + "resourcePost_edit.html";
    }

    /**
     * 获取动态资源表列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(String condition) {
        return resourcePostService.selectList(null);
    }

    /**
     * 新增动态资源表
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(ResourcePost resourcePost) {
        resourcePostService.insert(resourcePost);
        return SUCCESS_TIP;
    }

    /**
     * 删除动态资源表
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam Integer resourcePostId) {
        resourcePostService.deleteById(resourcePostId);
        return SUCCESS_TIP;
    }

    /**
     * 修改动态资源表
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(ResourcePost resourcePost) {
        resourcePostService.updateById(resourcePost);
        return SUCCESS_TIP;
    }

    /**
     * 动态资源表详情
     */
    @RequestMapping(value = "/detail/{resourcePostId}")
    @ResponseBody
    public Object detail(@PathVariable("resourcePostId") Integer resourcePostId) {
        return resourcePostService.selectById(resourcePostId);
    }
}
