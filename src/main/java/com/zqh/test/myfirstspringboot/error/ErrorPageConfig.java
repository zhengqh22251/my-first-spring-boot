package com.zqh.test.myfirstspringboot.error;

import org.springframework.boot.autoconfigure.web.embedded.EmbeddedWebServerFactoryCustomizerAutoConfiguration;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.ErrorPageRegistrar;
import org.springframework.boot.web.server.ErrorPageRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

/**
 * 自定义错误页面
 * @Author：zhengqh
 * @date 2020/4/14 19:56
 **/

@Component
public class ErrorPageConfig implements ErrorPageRegistrar{
    @Override
    public void registerErrorPages(ErrorPageRegistry registry) {
        /*ErrorPage error400Page=new ErrorPage(HttpStatus.BAD_REQUEST,"/error400" );
        ErrorPage error401Page=new ErrorPage(HttpStatus.UNAUTHORIZED,"/error401");
        ErrorPage error500Page=new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR,"/error500");*/
        ErrorPage error404Page=new ErrorPage(HttpStatus.NOT_FOUND,"/404.html");
        //registry.addErrorPages(error400Page,error401Page,error500Page);
        registry.addErrorPages(error404Page);
    }
    // EmbeddedServletContainerCustomizer 不支持
    //https://www.cnblogs.com/notably/p/10710165.html
}
