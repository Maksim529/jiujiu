
package com.mx.zmx.admin.rmp.service.impl;

import com.mx.zmx.admin.rmp.mapper.SysPermissionMapper;
import com.mx.zmx.admin.rmp.model.SysPermission;
import com.mx.zmx.admin.rmp.service.SysPermissionService;
import com.mx.zmx.core.service.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class SysPermissionServiceImpl extends CommonServiceImpl<SysPermission,Long> implements SysPermissionService,InitializingBean{
    @Resource
    private SysPermissionMapper sysPermissionMapper;



    @Override
    public void afterPropertiesSet() {
        super.commonMapper = sysPermissionMapper;
    }
}
