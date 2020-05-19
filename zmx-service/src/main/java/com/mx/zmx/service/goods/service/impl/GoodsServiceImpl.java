package com.mx.zmx.service.goods.service.impl;

import com.mx.zmx.service.goods.mapper.GoodsMapper;
import com.mx.zmx.service.goods.service.GoodsService;
import com.mx.zmx.model.Goods;
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
public class GoodsServiceImpl extends CommonServiceImpl<Goods,Long> implements GoodsService,InitializingBean{
    @Resource
    private GoodsMapper goodsMapper;

    @Override
    public void afterPropertiesSet() {
        super.commonMapper = goodsMapper;
    }
}
