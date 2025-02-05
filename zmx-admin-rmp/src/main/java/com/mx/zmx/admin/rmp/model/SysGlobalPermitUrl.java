package com.mx.zmx.admin.rmp.model;

import lombok.Data;

import java.io.Serializable;


@Data
public class SysGlobalPermitUrl implements Serializable{

    private Long id;//主键
    private String permitName;//通过名称
    private String backendUrlReg;//后端的地址正则,校验当前请求url是否有权限,get|post统一会按照参数首字母排序
    private Long moduleId;//所属模块


    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getPermitName(){
        return permitName;
    }
    public void setPermitName(String permitName){
        this.permitName = permitName;
    }

    public String getBackendUrlReg(){
        return backendUrlReg;
    }
    public void setBackendUrlReg(String backendUrlReg){
        this.backendUrlReg = backendUrlReg;
    }

    public Long getModuleId(){
        return moduleId;
    }
    public void setModuleId(Long moduleId){
        this.moduleId = moduleId;
    }
}
