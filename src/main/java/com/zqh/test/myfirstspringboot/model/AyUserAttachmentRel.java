package com.zqh.test.myfirstspringboot.model;

import lombok.Data;

import javax.persistence.Id;

/**
 * 用户附件类 mongodb
 * @Author：zhengqh
 * @date 2020/4/15 11:01
 **/
@Data
public class AyUserAttachmentRel {
    @Id
    private String id;
    private String userId;
    private String fileName;
}
