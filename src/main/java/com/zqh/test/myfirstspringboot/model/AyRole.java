package com.zqh.test.myfirstspringboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @Author：zhengqh
 * @date 2020/4/8 20:06
 * 角色
 **/
@Data
@Entity
@Table(name="ay_role")
public class AyRole implements Serializable {
    @Id
    private String id;
    private String name;
}
