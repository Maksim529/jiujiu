package com.mx.zmx.service.goodscategory.service.impl;

import com.mx.zmx.service.goodscategory.mapper.GoodsCategoryMapper;
import com.mx.zmx.service.goodscategory.service.GoodsCategoryService;
import com.mx.zmx.model.GoodsCategory;
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
public class GoodsCategoryServiceImpl extends CommonServiceImpl<GoodsCategory,Long> implements GoodsCategoryService,InitializingBean{
    @Resource
    private GoodsCategoryMapper goodsCategoryMapper;

    @Override
    public void afterPropertiesSet() {
        super.commonMapper = goodsCategoryMapper;
    }
}
