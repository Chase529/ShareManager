package com.stylefeng.guns.modular.system.warpper.biz_one;

import com.stylefeng.guns.core.base.warpper.BaseControllerWarpperPd;
import com.stylefeng.guns.core.common.constant.factory.ConstantFactory;
import com.stylefeng.guns.core.util.PageData;


import java.util.List;


public class PostWarpper extends BaseControllerWarpperPd {

    public PostWarpper(List<PageData> pd) {
        super(pd);
    }

    @Override
    protected void warpTheMap(PageData pd) {
        pd.put("isShowName", ConstantFactory.me().getPostStatusName((Integer) pd.get("is_show")));
    }
}
