package com.mx.zmx.admin.adminservice.demo.service.impl;

import com.mx.zmx.admin.adminservice.demo.mapper.AdminServiceDemoMapper;
import com.mx.zmx.admin.adminservice.demo.service.AdminServiceDemoService;
import com.mx.zmx.admin.model.MyDemo;
import com.mx.zmx.core.utils.MapUtil;
import com.mx.zmx.model.Goods;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminServiceDemoServiceImpl  implements AdminServiceDemoService {
    @Resource
    private AdminServiceDemoMapper adminServiceDemoMapper;

    @Override
    public MyDemo demoGoods(Long id) {
        return adminServiceDemoMapper.daoDemoGoods(MapUtil.buildMap("id",id));
    }
}
