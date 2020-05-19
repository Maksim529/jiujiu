package com.mx.zmx.admin.rmp.service;

import com.mx.zmx.admin.rmp.model.SysModule;
import com.mx.zmx.core.service.ICommonService;



public interface SysModuleService extends ICommonService<SysModule,Long>{

    /**
     * 保存模块与权限
     * @param helpConfigPermit 帮助配置权限
     * @param entity 模块实体类
     */
    void saveModule(Boolean helpConfigPermit,SysModule entity);

}
