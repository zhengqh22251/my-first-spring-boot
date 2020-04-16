package com.zqh.test.myfirstspringboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


/**
 * @Author：zhengqh
 * @date 2020/4/8 20:06
 **/
@Data
@Entity
@Table(name="ay_user")
public class AyUser implements Serializable {
    @Id
    private String id;
    private String name;
    private String password;
}
