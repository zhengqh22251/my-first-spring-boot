package com.zqh.test.myfirstspringboot.service.impl;

import com.zqh.test.myfirstspringboot.model.AyUser;
import com.zqh.test.myfirstspringboot.model.AyUserRoleRef;
import com.zqh.test.myfirstspringboot.service.AyRoleService;
import com.zqh.test.myfirstspringboot.service.AyUserRoleRefService;
import com.zqh.test.myfirstspringboot.service.AyUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author：zhengqh
 * @date 2020/4/15 17:48
 * 自定义用户服务类
 **/
@Service
public class CustomUserService implements UserDetailsService {

    @Resource
    private AyUserService ayUserService;
    @Resource
    private AyRoleService ayRoleService;
    @Resource
    private AyUserRoleRefService ayUserRoleRefService;

    @Override
    public UserDetails loadUserByUsername(String name) {
        AyUser ayUser = ayUserService.findByName(name).get(0);// 返回list  取第一个
        if(ayUser == null){
            try {
                throw new Exception("用户不存在！");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 获取用户所有关联的角色
        List<AyUserRoleRef> ayUserRoleRefList = ayUserRoleRefService.findByUserId(ayUser.getId());
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<GrantedAuthority>();
        if(ayUserRoleRefList != null && ayUserRoleRefList.size()>0){
            //获取用户关联角色名称
            for (AyUserRoleRef ref : ayUserRoleRefList) {
                String roleName = ayRoleService.find(ref.getRoleId()).getName();
                grantedAuthorityList.add(new SimpleGrantedAuthority(roleName));
            }
        }

        //Bad credentials异常
        // https://blog.csdn.net/qq_41950229/article/details/98479327
        return new User(ayUser.getName(),ayUser.getPassword(),grantedAuthorityList);
    }
}
