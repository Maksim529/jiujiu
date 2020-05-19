package com.mx.zmx.model;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.*;
import java.io.Serializable;
import lombok.Data;

@Data
public class GoodsCategory implements Serializable{

    private Long id;//主键ID
    private String name;//分类名称
    private String keyword;//关键词


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getKeyword(){
        return keyword;
    }
    public void setKeyword(String keyword){
        this.keyword = keyword;
    }
}
