
package com.mx.zmx.admin.rmp.service.impl;

import com.mx.zmx.admin.rmp.mapper.SysAdminUserMapper;
import com.mx.zmx.admin.rmp.model.SysAdminUser;
import com.mx.zmx.admin.rmp.service.SysAdminUserService;
import com.mx.zmx.core.service.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class SysAdminUserServiceImpl extends CommonServiceImpl<SysAdminUser,Long> implements SysAdminUserService,InitializingBean{
    @Resource
    private SysAdminUserMapper sysAdminUserMapper;



    @Override
    public void afterPropertiesSet() {
        super.commonMapper = sysAdminUserMapper;
    }
}
