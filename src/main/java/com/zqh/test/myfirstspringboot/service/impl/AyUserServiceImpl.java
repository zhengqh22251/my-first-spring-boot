package com.zqh.test.myfirstspringboot.service.impl;

import com.zqh.test.myfirstspringboot.dao.AyUserDao;
import com.zqh.test.myfirstspringboot.model.AyUser;
import com.zqh.test.myfirstspringboot.repository.AyUserRepository;
import com.zqh.test.myfirstspringboot.service.AyUserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Future;

/**
 * @Author：zhengqh
 * @date 2020/4/9 16:11
 **/
// 注释在类上，该类的所有的public方法都会开启事务
@Transactional
@Service
public class AyUserServiceImpl implements AyUserService {

    @Resource
    private AyUserRepository ayUserRepository;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    private AyUserDao ayUserDao;

    private static final String ALL_USER = "ALL_USER_LIST";

    //日志
    Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public AyUser findById(String id) {
        //return ayUserRepository.findById(id).get();
        // 加redis缓存
        // 1、查询redis缓存中的所有数据
        List<AyUser> ayUsers = redisTemplate.opsForList().range(ALL_USER,0,-1);
        if(ayUsers != null && ayUsers.size()>0){
            for (AyUser ayUser : ayUsers) {
                if (ayUser.getId().equals(id)) {
                    System.out.println("------>缓存命中！！！");
                    return ayUser;
                }
            }
        }

        //2、查询数据库中的数据
        AyUser ayUser = null;
        if(ayUserRepository.findById(id).isPresent()){
            ayUser = ayUserRepository.findById(id).get();
        }
        System.out.println("------>查询数据库！！！");
        if(ayUser != null){
            // 将数据插入到redis缓存中
            redisTemplate.opsForList().leftPush(ALL_USER,ayUser);
        }
        return ayUser;
    }

    @Override
    public List<AyUser> findAll() {
        try {
            logger.info("开始做任务");
            System.out.println("开始做任务");
            long start = System.currentTimeMillis();
            List<AyUser> ayUsers = ayUserRepository.findAll();
            long end = System.currentTimeMillis();
            logger.info("完成任务，耗时："+(end-start)+"毫秒");
            System.out.println("完成任务，耗时："+(end-start)+"毫秒");
            return ayUsers;
        } catch (Exception e) {
            logger.error("method 【findAll】 has error"+e);
            return Collections.EMPTY_LIST;
        }
    }

    // 异步查询所有用户
    @Override
    @Async
    public Future<List<AyUser>> findAsynAll() {
        try {
            logger.info("开始做任务");
            long start = System.currentTimeMillis();
            List<AyUser> ayUsers = ayUserRepository.findAll();
            long end = System.currentTimeMillis();
            logger.info("完成任务，耗时："+(end-start)+"毫秒");
            return new AsyncResult<List<AyUser>>(ayUsers);
        } catch (Exception e) {
            logger.error("method 【findAsynAll】 has error"+e);
            return new AsyncResult<List<AyUser>>(null);
        }
    }

    // 方法级别覆盖类上的事务
    @Transactional
    @Override
    public AyUser save(AyUser ayUser) {
        return ayUserRepository.save(ayUser);
    }

    @Override
    public void delete(String id) {
        ayUserRepository.deleteById(id);
        logger.info("userid--->"+id+"被删除！");
    }

    @Override
    public Page<AyUser> findAll(Pageable pageable) {
        return ayUserRepository.findAll(pageable);
    }

    @Override
    public List<AyUser> findByName(String name) {
        return ayUserRepository.findByName(name);
    }

    @Override
    public List<AyUser> findByNameLike(String name) {
        return ayUserRepository.findByNameLike(name);
    }

    @Override
    public List<AyUser> findByIdIn(Collection<String> ids) {
        return ayUserRepository.findByIdIn(ids);
    }

    @Override
    public AyUser findByNameAndPassword(String name, String password) {
        return ayUserDao.findByNameAndPassword(name,password);
    }

    @Override
    @Retryable(value={Exception.class},maxAttempts = 5,
            backoff = @Backoff(delay = 5000,multiplier = 2))
    public AyUser findByNameAndPasswordRetry(String name, String password) throws Exception {
       logger.info("方法【findByNameAndPasswordRetry】重试了！！");
       throw new Exception();
    }

}
