package com.mx.zmx.web.webservice.goods.mapper;

import com.mx.zmx.web.model.WebGoods;

import java.util.Map;



public interface WebGoodsMapper{

    WebGoods getWebGoods(Map<String,Object> query);

}
