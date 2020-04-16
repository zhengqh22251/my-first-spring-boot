package com.zqh.test.myfirstspringboot.filter;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author：zhengqh
 * @date 2020/4/8 21:02
 **/

@Configuration
public class DruidConfiguration {
    @Bean
    public ServletRegistrationBean druidStatViewServle(){
        // ServletRegistrationBean 提供类的进行注册
        ServletRegistrationBean servletRegistrationBean
                =new ServletRegistrationBean(new StatViewServlet(),"/druid/*");
        //添加初始化参数
        //白名单
        servletRegistrationBean.addInitParameter("allow","127.0.0.1");
        //ip黑名单 存在共同时 deny优先于allow
        servletRegistrationBean.addInitParameter("deny","192.168.185.196");
        //登录查看信息的账号和密码
        servletRegistrationBean.addInitParameter("loginUsername","root");
        servletRegistrationBean.addInitParameter("loginPassword","zqh124");
        //是否重置数据
        servletRegistrationBean.addInitParameter("resetEnable","false");
        return  servletRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean druidStatFilter(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean(new WebStatFilter());
        // 添加过滤规则
        filterRegistrationBean.addUrlPatterns("/*");
        //添加需要忽略的格式信息
        filterRegistrationBean.addInitParameter("exclusions",
                "*.js,*.jpg,*.gif,*.png,*.css,*.ico,/druid/*");
        return filterRegistrationBean;
    }


}
