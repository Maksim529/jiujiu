
//表单通用配置 列表页 详情页都需要 基本已经废弃
layui.define(['jquery'],function(exports){
    var obj =
        {
            tableNameRest:"goods_img_rest",
            tableName:"goods_img",
            moduleName:"goods_img",//sys_module的moduleName
            form:{}
        }
    exports('goodsimg_config',obj);
})
