
//表单通用配置 列表页 详情页都需要 基本已经废弃
layui.define(['jquery'],function(exports){
    var obj =
        {
            tableNameRest:"goods_file_rest",
            tableName:"goods_file",
            moduleName:"goods_file",//sys_module的moduleName
            form:{}
        }
    exports('goodsfile_config',obj);
})
