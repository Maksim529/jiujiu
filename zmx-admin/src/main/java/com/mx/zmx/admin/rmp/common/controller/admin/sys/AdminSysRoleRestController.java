package com.mx.zmx.admin.rmp.common.controller.admin.sys;

import com.mx.zmx.admin.rmp.model.SysRole;
import com.mx.zmx.admin.rmp.service.SysRoleService;
import com.mx.zmx.core.common.constant.PageConstant;
import com.mx.zmx.core.serialize.ResponseMsg;
import com.mx.zmx.core.service.CommonRestController;
import com.mx.zmx.core.utils.ListUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;




@RequestMapping("/admin/sys_role_rest/")
@RestController
public class AdminSysRoleRestController extends CommonRestController<SysRole,Long> implements InitializingBean
{

    @Resource
    private SysRoleService sysRoleService;

        @RequestMapping(value = "search")
    public ResponseMsg search(
            @RequestParam(required = false) String uniqueField,
            @RequestParam(required = false,value = "uniqueValue[]") Set<Long> uniqueValue,//主键多个值
            @RequestParam(required = false,defaultValue = "20") Integer limit,
            @RequestParam(required = false) String keyword
    ){
        limit = Math.min(PageConstant.MAX_LIMIT,limit);
        List<SysRole> list = null;
        Map<String,Object> query = new HashMap();
        query.put("limit",limit);
        if(uniqueValue!=null){//说明是来初始化的
            list = sysRoleService.getModelInList(uniqueValue);
        }else {//正常搜索
            query.put("roleNameFirst",keyword);
            list = sysRoleService.getModelList(query);
            query.remove("roleNameFirst");
        }
        return new ResponseMsg(list);
    }
    //分页查询
    @RequestMapping(value={"page"}, method={RequestMethod.GET})
    public ResponseMsg page(
        @RequestParam(required = false,value ="roleNameFirst")                            String roleNameFirst ,
        @RequestParam int page, @RequestParam int limit, @RequestParam(required = false) String safeOrderBy
        , HttpServletResponse response, @RequestParam(required = false) Integer queryType
    ){
        Map<String,Object> query = new HashMap();
        query.put("roleNameFirst",coverBlankToNull(roleNameFirst));
        Integer count = sysRoleService.getModelListCount(query);
        query.put("safeOrderBy",safeOrderBy);
        if(queryType==null || queryType == QUERY_TYPE_SEARCH){//普通查询
            limit = Math.min(limit, PageConstant.MAX_LIMIT);
            query.put("start",(page - 1) * limit);query.put("limit",limit);
            return new ResponseMsg(count,sysRoleService.getModelList(query));
        }else if(queryType == QUERY_TYPE_EXPORT_EXCEL){
            query.put("start",(page - 1) * limit);query.put("limit",limit);
            exportExcel(response,sysRoleService.getModelList(query),"角色",
            new String[]{"主键","角色名"},
            new String[]{"",""});
        }
        return null;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.commonService = sysRoleService;
        super.primaryKey = "id";//硬编码此实体的主键名称
    }
}
