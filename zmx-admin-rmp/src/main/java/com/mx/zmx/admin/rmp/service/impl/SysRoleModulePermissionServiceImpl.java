
package com.mx.zmx.admin.rmp.service.impl;

import com.mx.zmx.admin.rmp.mapper.SysRoleModulePermissionMapper;
import com.mx.zmx.admin.rmp.model.SysRoleModulePermission;
import com.mx.zmx.admin.rmp.service.SysRoleModulePermissionService;
import com.mx.zmx.core.service.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class SysRoleModulePermissionServiceImpl extends CommonServiceImpl<SysRoleModulePermission,Long> implements SysRoleModulePermissionService,InitializingBean{
    @Resource
    private SysRoleModulePermissionMapper sysRoleModulePermissionMapper;



    @Override
    public void afterPropertiesSet() {
        super.commonMapper = sysRoleModulePermissionMapper;
    }
}
