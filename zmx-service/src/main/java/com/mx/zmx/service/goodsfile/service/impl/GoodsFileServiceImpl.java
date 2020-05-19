package com.mx.zmx.service.goodsfile.service.impl;

import com.mx.zmx.service.goodsfile.mapper.GoodsFileMapper;
import com.mx.zmx.service.goodsfile.service.GoodsFileService;
import com.mx.zmx.model.GoodsFile;
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
import java.math.*;


@Service
public class GoodsFileServiceImpl extends CommonServiceImpl<GoodsFile,Long> implements GoodsFileService,InitializingBean{
    @Resource
    private GoodsFileMapper goodsFileMapper;

    @Override
    public void afterPropertiesSet() {
        super.commonMapper = goodsFileMapper;
    }
}
