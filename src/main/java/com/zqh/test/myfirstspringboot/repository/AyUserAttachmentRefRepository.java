package com.zqh.test.myfirstspringboot.repository;

import com.zqh.test.myfirstspringboot.model.AyUserAttachmentRel;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @Author：zhengqh
 * @date 2020/4/15 11:03
 **/
public interface AyUserAttachmentRefRepository
        extends MongoRepository<AyUserAttachmentRel,String> {
}
