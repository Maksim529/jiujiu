package com.mx.zmx.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {
        "com.mx.zmx.core",
        "com.mx.zmx.service",
        "com.mx.zmx.admin"
        })
/*让过滤器WebFilter生效*/
@ServletComponentScan(basePackages = {
    "com.mx.zmx.admin.common.filter",
    "com.mx.zmx.admin.rmp.common.filter"
})
public class YouyaBootAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(YouyaBootAdminApplication.class, args);
    }

}
