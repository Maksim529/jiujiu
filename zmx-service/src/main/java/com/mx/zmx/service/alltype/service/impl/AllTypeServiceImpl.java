package com.mx.zmx.service.alltype.service.impl;

import com.mx.zmx.service.alltype.mapper.AllTypeMapper;
import com.mx.zmx.service.alltype.service.AllTypeService;
import com.mx.zmx.model.AllType;
import com.mx.zmx.core.service.CommonServiceImpl;
import com.mx.zmx.core.utils.StringUtil;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;
import com.mx.zmx.core.utils.CopyUtil;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.math.*;


@Service
public class AllTypeServiceImpl extends CommonServiceImpl<AllType,Long> implements AllTypeService,InitializingBean{
    @Resource
    private AllTypeMapper allTypeMapper;

    @Override
    public void afterPropertiesSet() {
        super.commonMapper = allTypeMapper;
    }
}
