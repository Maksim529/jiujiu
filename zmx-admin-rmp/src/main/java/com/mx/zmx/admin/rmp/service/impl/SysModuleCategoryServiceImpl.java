
package com.mx.zmx.admin.rmp.service.impl;

import com.mx.zmx.admin.rmp.mapper.SysModuleCategoryMapper;
import com.mx.zmx.admin.rmp.model.SysModuleCategory;
import com.mx.zmx.admin.rmp.service.SysModuleCategoryService;
import com.mx.zmx.core.service.CommonServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;



@Service
public class SysModuleCategoryServiceImpl extends CommonServiceImpl<SysModuleCategory,Long> implements SysModuleCategoryService,InitializingBean{
    @Resource
    private SysModuleCategoryMapper sysModuleCategoryMapper;



    @Override
    public void afterPropertiesSet() {
        super.commonMapper = sysModuleCategoryMapper;
    }
}
