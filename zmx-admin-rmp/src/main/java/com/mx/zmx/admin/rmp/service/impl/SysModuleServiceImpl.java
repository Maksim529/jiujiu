
package com.mx.zmx.admin.rmp.service.impl;

import com.mx.zmx.admin.rmp.constant.PermissionConstant;
import com.mx.zmx.admin.rmp.mapper.SysModuleMapper;
import com.mx.zmx.admin.rmp.model.SysModule;
import com.mx.zmx.admin.rmp.model.SysPermission;
import com.mx.zmx.admin.rmp.service.SysModuleService;
import com.mx.zmx.admin.rmp.service.SysPermissionService;
import com.mx.zmx.core.service.CommonServiceImpl;
import com.mx.zmx.core.utils.ListUtil;
import com.mx.zmx.core.utils.MapUtil;
import com.mx.zmx.core.utils.StringUtil;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;



@Service
public class SysModuleServiceImpl extends CommonServiceImpl<SysModule,Long> implements SysModuleService,InitializingBean{
    @Resource
    private SysModuleMapper sysModuleMapper;

    @Resource
    private SysPermissionService sysPermissionService;
    @Override
    public void afterPropertiesSet() {
        super.commonMapper = sysModuleMapper;
    }

    @Transactional
    @Override
    public void saveModule(Boolean helpConfigPermit,SysModule entity) {
        Long id = entity.getId();
        if(entity.getSortNum()==null){
            entity.setSortNum(0);
        }
        if(id==null){
            insertModel(entity);
        }else{
            SysModule dbEntity = getModelNotIgnore(id,"id");
            if(dbEntity==null){//
                insertModel(entity);
            }else {
                updateModel(entity);
            }
        }
        if(helpConfigPermit!=null && helpConfigPermit){//辅助用户 创建此模块下一条默认的所有权限
            Long moduleId = entity.getId();
            String url = entity.getModuleUrl();
            if(StringUtil.isNotBlank(url)){
                String urlReg = "admin/page_v2/(\\w+)/list.*";
                if(url.matches(urlReg)){
                    String tableName = url.replaceAll(urlReg,"$1").toLowerCase();
                    if(StringUtil.isNotBlank(tableName)){
                        String backendUrlReg = "/admin/"+tableName+"_rest/[\\s\\S]*";
                        List<SysPermission> existPermissionList = this.sysPermissionService.getModelList(MapUtil.buildMap("moduleId",moduleId));
                        boolean exist = false;
                        if(ListUtil.isNotBlank(existPermissionList)){
                            for(SysPermission permission : existPermissionList){
                                if(backendUrlReg.equals(permission.getBackendUrlReg())){
                                    exist = true;
                                    break;
                                }
                            }
                        }
                        if(!exist){
                            SysPermission sysPermission = new SysPermission();
                            sysPermission.setModuleId(moduleId);
                            sysPermission.setPermissionName("全部权限");
                            sysPermission.setFilterPlatform(PermissionConstant.Platform.BACKEND.getValue());//后端
                            sysPermission.setBackendUrlReg(backendUrlReg);
                            this.sysPermissionService.insertModel(sysPermission);
                        }
                    }
                }
            }
        }
    }
}
