package com.zqh.test.myfirstspringboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author：zhengqh
 * @date 2020/4/14 17:29
 **/

@Data
@Entity
@Table(name="ay_mood")
public class AyMood implements Serializable {
    @Id
    private String id;
    // 说说内容
    private String content;
    // 用户id
    private String userId;
    // 点赞数量
    private Integer praiseNum;
    // 发表时间
    private Date publishTime;

}
