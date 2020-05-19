
//表单通用配置 列表页 详情页都需要 已经废弃
layui.define(['jquery'],function(exports){
    var obj =
        {
            tableNameRest:"goods_rest",
            tableName:"goods",
            moduleName:"goods",//sys_module的moduleName
            form:{}
        }
    exports('goods_config',obj);
})
