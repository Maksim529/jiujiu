package com.mx.zmx.service.dict.service.impl;

import com.mx.zmx.service.dict.mapper.DictMapper;
import com.mx.zmx.service.dict.service.DictService;
import com.mx.zmx.model.Dict;
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
public class DictServiceImpl extends CommonServiceImpl<Dict,Long> implements DictService,InitializingBean{
    @Resource
    private DictMapper dictMapper;

    @Override
    public void afterPropertiesSet() {
        super.commonMapper = dictMapper;
    }
}
