/**
 * 初始化动态资源表详情对话框
 */
var ResourcePostInfoDlg = {
    resourcePostInfoData : {}
};

/**
 * 清除数据
 */
ResourcePostInfoDlg.clearData = function() {
    this.resourcePostInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ResourcePostInfoDlg.set = function(key, val) {
    this.resourcePostInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
ResourcePostInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
ResourcePostInfoDlg.close = function() {
    parent.layer.close(window.parent.ResourcePost.layerIndex);
}

/**
 * 收集数据
 */
ResourcePostInfoDlg.collectData = function() {
    this
    .set('resId')
    .set('resUrl')
    .set('resType')
    .set('resDesc')
    .set('relationId')
    .set('createTime');
}

/**
 * 提交添加
 */
ResourcePostInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/resourcePost/add", function(data){
        Feng.success("添加成功!");
        window.parent.ResourcePost.table.refresh();
        ResourcePostInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.resourcePostInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
ResourcePostInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/resourcePost/update", function(data){
        Feng.success("修改成功!");
        window.parent.ResourcePost.table.refresh();
        ResourcePostInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.resourcePostInfoData);
    ajax.start();
}

$(function() {

});
