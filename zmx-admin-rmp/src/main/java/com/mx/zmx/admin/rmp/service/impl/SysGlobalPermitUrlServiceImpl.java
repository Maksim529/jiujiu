
package com.mx.zmx.admin.rmp.service.impl;

import com.mx.zmx.admin.rmp.mapper.SysGlobalPermitUrlMapper;
import com.mx.zmx.admin.rmp.model.SysGlobalPermitUrl;
import com.mx.zmx.admin.rmp.service.SysGlobalPermitUrlService;
import com.mx.zmx.core.service.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class SysGlobalPermitUrlServiceImpl extends CommonServiceImpl<SysGlobalPermitUrl,Long> implements SysGlobalPermitUrlService,InitializingBean{
    @Resource
    private SysGlobalPermitUrlMapper sysGlobalPermitUrlMapper;



    @Override
    public void afterPropertiesSet() {
        super.commonMapper = sysGlobalPermitUrlMapper;
    }
}
