package com.zqh.test.myfirstspringboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @Author：zhengqh
 * @date 2020/4/8 20:06
 * 用户 角色 关联
 **/
@Data
@Entity
@Table(name="ay_user_role_ref")
public class AyUserRoleRef implements Serializable {
    @Id
    private String userId;
    private String roleId;
}
