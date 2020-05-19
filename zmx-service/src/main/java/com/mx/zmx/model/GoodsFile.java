package com.mx.zmx.model;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.*;
import java.io.Serializable;
import lombok.Data;

@Data
public class GoodsFile implements Serializable{

    private Long fileId;//主键
    private String fileSrc;//文件地址
    private Long goodsId;//所属商品


    public Long getFileId(){
        return fileId;
    }
    public void setFileId(Long fileId){
        this.fileId = fileId;
    }

    public String getFileSrc(){
        return fileSrc;
    }
    public void setFileSrc(String fileSrc){
        this.fileSrc = fileSrc;
    }

    public Long getGoodsId(){
        return goodsId;
    }
    public void setGoodsId(Long goodsId){
        this.goodsId = goodsId;
    }
}
