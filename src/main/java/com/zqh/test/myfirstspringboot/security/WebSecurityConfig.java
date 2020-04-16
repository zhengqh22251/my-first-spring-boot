package com.zqh.test.myfirstspringboot.security;

import com.zqh.test.myfirstspringboot.service.impl.CustomUserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @Author：zhengqh
 * @date 2020/4/15 11:35
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 用户 角色（权限） 校验
    @Bean
    public CustomUserService customUserService(){
        return  new CustomUserService();
    }

    // 在内存中设置用户
    // There is no PasswordEncoder mapped for the id "null"
    //https://blog.csdn.net/canon_in_d_major/article/details/79675033
    //https://bbs.csdn.net/topics/392517221?list=lz
    // /*  5.0 之后密码 加密格式*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder(){

            @Override
            public String encode(CharSequence charSequence) {
                return  charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return s.equals(charSequence.toString());
            }
        });
               /* .userDetailsService(customUserService()).passwordEncoder(NoOpPasswordEncoder.getInstance());*/
                /*.inMemoryAuthentication();
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("郑求华").password(new BCryptPasswordEncoder().encode("123456")).roles("ADMIN")
                .and()
                .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("阿毅").password(new BCryptPasswordEncoder().encode("123456")).roles("USER");
*/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 路由策略和访问权限的简单配置
        http
                .formLogin()
                .failureUrl("/login?error") //登录失败返回url
                .defaultSuccessUrl("/ayUser/test") //成功跳转的url 这里是用户首页
                .permitAll(); //登录页面全部权限可访问
        super.configure(http);
    }

}
