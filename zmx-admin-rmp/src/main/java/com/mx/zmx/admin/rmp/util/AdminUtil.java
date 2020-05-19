package com.mx.zmx.admin.rmp.util;

import com.mx.zmx.admin.rmp.dto.SysAdminUserDto;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * author:www.maoxing.vip
 * date:2018/7/17
 * function:
 */
public class AdminUtil {

    public static SysAdminUserDto getAdmin(){
        SysAdminUserDto sysAdminUserDto = (SysAdminUserDto)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return sysAdminUserDto;
    }

    public static Long getAdminUid(){
        return getAdmin().getId();
    }

}
