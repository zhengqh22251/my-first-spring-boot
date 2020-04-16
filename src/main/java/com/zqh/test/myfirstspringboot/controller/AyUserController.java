package com.zqh.test.myfirstspringboot.controller;

import com.zqh.test.myfirstspringboot.model.AyUser;
import com.zqh.test.myfirstspringboot.service.AyUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author：zhengqh
 * @date 2020/4/11 22:51
 **/
@Controller
@RequestMapping("/ayUser")
public class AyUserController {
    @Resource
    private AyUserService ayUserService;
    @RequestMapping("/test")
    public String test(Model model){
        List<AyUser> ayUser= ayUserService.findAll();
        model.addAttribute("users",ayUser);
        return "ayUser";
    }

    // 测试异常处理
    @RequestMapping("/findAll")
    public String findAll(Model model) throws Exception {
        List<AyUser>  ayUsers = ayUserService.findAll();
        model.addAttribute("users",ayUsers);
        throw new Exception("业务异常");
    }

    @RequestMapping("/findByNameAndPasswordRetry")
    public String findByNameAndPasswordRetry(Model model) throws Exception {
        AyUser ayUser = ayUserService.findByNameAndPasswordRetry("阿笑","123456");
        model.addAttribute("users",ayUser);
        return "success";
    }
}
