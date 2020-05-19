package com.mx.zmx.admin.adminservice.demo.mapper;

import com.mx.zmx.admin.model.MyDemo;
import com.mx.zmx.model.Goods;

import java.util.Map;

public interface AdminServiceDemoMapper {
    MyDemo daoDemoGoods(Map<String,Object> query);

}
