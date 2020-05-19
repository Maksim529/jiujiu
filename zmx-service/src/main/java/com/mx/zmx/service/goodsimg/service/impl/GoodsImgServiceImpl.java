package com.mx.zmx.service.goodsimg.service.impl;

import com.mx.zmx.service.goodsimg.mapper.GoodsImgMapper;
import com.mx.zmx.service.goodsimg.service.GoodsImgService;
import com.mx.zmx.model.GoodsImg;
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
public class GoodsImgServiceImpl extends CommonServiceImpl<GoodsImg,Long> implements GoodsImgService,InitializingBean{
    @Resource
    private GoodsImgMapper goodsImgMapper;

    @Override
    public void afterPropertiesSet() {
        super.commonMapper = goodsImgMapper;
    }
}
