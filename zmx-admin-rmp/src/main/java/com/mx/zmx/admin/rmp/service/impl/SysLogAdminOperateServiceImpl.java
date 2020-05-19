
package com.mx.zmx.admin.rmp.service.impl;

import com.mx.zmx.admin.rmp.mapper.SysLogAdminOperateMapper;
import com.mx.zmx.admin.rmp.model.SysLogAdminOperate;
import com.mx.zmx.admin.rmp.service.SysLogAdminOperateService;
import com.mx.zmx.core.service.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class SysLogAdminOperateServiceImpl extends CommonServiceImpl<SysLogAdminOperate,Long> implements SysLogAdminOperateService,InitializingBean{
    @Resource
    private SysLogAdminOperateMapper sysLogAdminOperateMapper;



    @Override
    public void afterPropertiesSet() {
        super.commonMapper = sysLogAdminOperateMapper;
    }
}
