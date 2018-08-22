/**
 * 初始化发布动态管理详情对话框
 */
var PostInfoDlg = {
    postInfoData : {}
};

/**
 * 清除数据
 */
PostInfoDlg.clearData = function() {
    this.postInfoData = {};
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PostInfoDlg.set = function(key, val) {
    this.postInfoData[key] = (typeof val == "undefined") ? $("#" + key).val() : val;
    return this;
}

/**
 * 设置对话框中的数据
 *
 * @param key 数据的名称
 * @param val 数据的具体值
 */
PostInfoDlg.get = function(key) {
    return $("#" + key).val();
}

/**
 * 关闭此对话框
 */
PostInfoDlg.close = function() {
    parent.layer.close(window.parent.Post.layerIndex);
}

/**
 * 收集数据
 */
PostInfoDlg.collectData = function() {
    this
    .set('postId')
    .set('postTitle')
    .set('postShort')
    .set('postStory')
    .set('isShow')
    .set('clickCount')
    .set('likeCount')
    .set('postUid')
    .set('createTime')
    .set('updateTime');
}

/**
 * 提交添加
 */
PostInfoDlg.addSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/post/add", function(data){
        Feng.success("添加成功!");
        window.parent.Post.table.refresh();
        PostInfoDlg.close();
    },function(data){
        Feng.error("添加失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.postInfoData);
    ajax.start();
}

/**
 * 提交修改
 */
PostInfoDlg.editSubmit = function() {

    this.clearData();
    this.collectData();

    //提交信息
    var ajax = new $ax(Feng.ctxPath + "/post/update", function(data){
        Feng.success("修改成功!");
        window.parent.Post.table.refresh();
        PostInfoDlg.close();
    },function(data){
        Feng.error("修改失败!" + data.responseJSON.message + "!");
    });
    ajax.set(this.postInfoData);
    ajax.start();
}

$(function() {

});
