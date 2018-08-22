/**
 * 发布动态管理管理初始化
 */
var Post = {
    id: "PostTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Post.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'postId', visible: true, align: 'center', valign: 'middle'},
            {title: '标题', field: 'postTitle', visible: true, align: 'center', valign: 'middle'},
            {title: '简介', field: 'postShort', visible: true, align: 'center', valign: 'middle'},
            {title: '故事', field: 'postStory', visible: true, align: 'center', valign: 'middle'},
            {title: '状态', field: 'isShowName', visible: true, align: 'center', valign: 'middle'},
            {title: '点击量', field: 'clickCount', visible: true, align: 'center', valign: 'middle'},
            {title: '喜欢数量', field: 'likeCount', visible: true, align: 'center', valign: 'middle'},
            {title: '发布人', field: 'postUid', visible: true, align: 'center', valign: 'middle'},
            {title: '发布时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'},
            {title: '修改时间', field: 'updateTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
Post.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        Post.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加发布动态管理
 */
Post.openAddPost = function () {
    var index = layer.open({
        type: 2,
        title: '添加发布动态管理',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/post/post_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看发布动态管理详情
 */
Post.openPostDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '发布动态管理详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/post/post_update/' + Post.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除发布动态管理
 */
Post.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/post/delete", function (data) {
            Feng.success("删除成功!");
            Post.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("postId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询发布动态管理列表
 */
Post.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    Post.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = Post.initColumn();
    var table = new BSTable(Post.id, "/post/list", defaultColunms);
    table.setPaginationType("client");
    Post.table = table.init();
});
