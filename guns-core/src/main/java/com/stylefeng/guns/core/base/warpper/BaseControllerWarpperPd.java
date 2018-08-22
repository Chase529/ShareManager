package com.stylefeng.guns.core.base.warpper;

import com.stylefeng.guns.core.util.PageData;

import java.util.List;
import java.util.Map;

/**
 * PageData版本wrapper
 */
public abstract class BaseControllerWarpperPd {

    public Object obj = null;

    public BaseControllerWarpperPd(Object obj) {
        this.obj = obj;
    }

    @SuppressWarnings("unchecked")
    public Object warp() {
        if (this.obj instanceof List) {
            List<PageData> list = (List<PageData>) this.obj;
            for (PageData map : list) {
                warpTheMap(map);
            }
            return list;
        } else if (this.obj instanceof PageData) {
            PageData map = (PageData) this.obj;
            warpTheMap(map);
            return map;
        } else {
            return this.obj;
        }
    }

    protected abstract void warpTheMap(PageData pd);

}
