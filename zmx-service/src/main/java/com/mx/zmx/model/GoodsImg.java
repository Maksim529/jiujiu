package com.mx.zmx.model;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.*;
import java.io.Serializable;
import lombok.Data;

@Data
public class GoodsImg implements Serializable{

    private Long imgId;//主键
    private String imgSrc;//图片地址
    private Long goodsId;//所属商品


    public Long getImgId(){
        return imgId;
    }
    public void setImgId(Long imgId){
        this.imgId = imgId;
    }

    public String getImgSrc(){
        return imgSrc;
    }
    public void setImgSrc(String imgSrc){
        this.imgSrc = imgSrc;
    }

    public Long getGoodsId(){
        return goodsId;
    }
    public void setGoodsId(Long goodsId){
        this.goodsId = goodsId;
    }
}
