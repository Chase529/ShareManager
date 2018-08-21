package com.stylefeng.guns.modular.system.warpper.biz_one;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpper;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;

import java.util.List;
import java.util.Map;

public class PostWarpper extends BaseControllerWarpper {

    public PostWarpper(Object obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        map.put("isShowName", ConstantFactory.me().getPostStatusName((Integer) map.get("sex")));
    }
}
