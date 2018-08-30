/**
 * 动态资源表管理初始化
 */
var ResourcePost = {
    id: "ResourcePostTable",	//表格id
    seItem: null,		//选中的条目
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
ResourcePost.initColumn = function () {
    return [
        {field: 'selectItem', radio: true},
            {title: '主键', field: 'resId', visible: true, align: 'center', valign: 'middle'},
            {title: '资源地址', field: 'resUrl', visible: true, align: 'center', valign: 'middle'},
            {title: '1图片 2视频 3其他', field: 'resType', visible: true, align: 'center', valign: 'middle'},
            {title: '描述', field: 'resDesc', visible: true, align: 'center', valign: 'middle'},
            {title: '关联id', field: 'relationId', visible: true, align: 'center', valign: 'middle'},
            {title: '创建时间', field: 'createTime', visible: true, align: 'center', valign: 'middle'}
    ];
};

/**
 * 检查是否选中
 */
ResourcePost.check = function () {
    var selected = $('#' + this.id).bootstrapTable('getSelections');
    if(selected.length == 0){
        Feng.info("请先选中表格中的某一记录！");
        return false;
    }else{
        ResourcePost.seItem = selected[0];
        return true;
    }
};

/**
 * 点击添加动态资源表
 */
ResourcePost.openAddResourcePost = function () {
    var index = layer.open({
        type: 2,
        title: '添加动态资源表',
        area: ['800px', '420px'], //宽高
        fix: false, //不固定
        maxmin: true,
        content: Feng.ctxPath + '/resourcePost/resourcePost_add'
    });
    this.layerIndex = index;
};

/**
 * 打开查看动态资源表详情
 */
ResourcePost.openResourcePostDetail = function () {
    if (this.check()) {
        var index = layer.open({
            type: 2,
            title: '动态资源表详情',
            area: ['800px', '420px'], //宽高
            fix: false, //不固定
            maxmin: true,
            content: Feng.ctxPath + '/resourcePost/resourcePost_update/' + ResourcePost.seItem.id
        });
        this.layerIndex = index;
    }
};

/**
 * 删除动态资源表
 */
ResourcePost.delete = function () {
    if (this.check()) {
        var ajax = new $ax(Feng.ctxPath + "/resourcePost/delete", function (data) {
            Feng.success("删除成功!");
            ResourcePost.table.refresh();
        }, function (data) {
            Feng.error("删除失败!" + data.responseJSON.message + "!");
        });
        ajax.set("resourcePostId",this.seItem.id);
        ajax.start();
    }
};

/**
 * 查询动态资源表列表
 */
ResourcePost.search = function () {
    var queryData = {};
    queryData['condition'] = $("#condition").val();
    ResourcePost.table.refresh({query: queryData});
};

$(function () {
    var defaultColunms = ResourcePost.initColumn();
    var table = new BSTable(ResourcePost.id, "/resourcePost/list", defaultColunms);
    table.setPaginationType("client");
    ResourcePost.table = table.init();
});
