package com.zqh.test.myfirstspringboot;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class MyFirstSpringBootApplicationTests {

    /*@Test
    void contextLoads() {
    }
    //测试数据库连接等是否正常
    @Resource
    private JdbcTemplate jdbcTemplate;
    @Test
    public void  MySQLTest(){
        String sql ="select id,name,password from ay_user";
        List<AyUser> list = (List<AyUser>)jdbcTemplate.query(sql, new RowMapper<AyUser>() {
            @Override
            public AyUser mapRow(ResultSet resultSet, int i) throws SQLException {
                AyUser ayUser = new AyUser();
                ayUser.setId(resultSet.getString("id"));
                ayUser.setName(resultSet.getString("name"));
                ayUser.setPassword(resultSet.getString("password"));
                return ayUser;
            }
        });
        System.out.println("查询成功！");
        for (AyUser ayUser:list) {
            System.out.println(
                    "id:"+ayUser.getId()+","+
                    "name:"+ayUser.getName()+","+
                    "passwrod:"+ayUser.getPassword()
            );
        }
    }


    @Resource
    private  AyUserService ayUserService;
    @Test
    void save() {
        AyUser ayUser = new AyUser();
        ayUser.setId("9");
        ayUser.setName("redis");
        ayUser.setPassword("123456");
        ayUserService.save(ayUser);
    }

    @Test
    void findAll(){
        List<AyUser> list = ayUserService.findAll();
        System.out.println(list.size());
    }

    @Test
    void  findByName(){
        List<AyUser> list = ayUserService.findByName("阿笑");
        System.out.println(list.size());
    }

    @Test
    void findById(){
        AyUser ayUser = ayUserService.findById("9");
        System.out.println(ayUser);
    }

    // 分页查询
    @Test
    void findAllPage(){
        PageRequest pageRequest  = PageRequest.of(0,3, Sort.Direction.ASC,"id");
        Page<AyUser> userList = ayUserService.findAll(pageRequest);
        System.out.println(userList.getTotalPages()+"----"+userList.getSize());
    }




    // redis 测试
    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedis(){
        redisTemplate.opsForValue().set("zqh","ay");
        String name = (String) redisTemplate.opsForValue().get("zqh");
        redisTemplate.opsForValue().set("zqh","zqh");
        System.out.println("---------------->"+name);

    }

    // 测试删除  记录日志
    @Test
    void delete(){
        ayUserService.delete("9");
    }

    private static final Logger logger = LogManager.getLogger(MyFirstSpringBootApplicationTests.class);

    @Test
    void findByNameAndPassword(){
        AyUser ayUser = ayUserService.findByNameAndPassword("阿笑","123456");
        logger.info("id："+ayUser.getId()+"---> name："+ayUser.getName());
    }

    @Resource
    private AyMoodService ayMoodService;
    @Test
    void moodSave(){
        AyMood ayMood = new AyMood();
        ayMood.setId("1");
        ayMood.setUserId("1");
        ayMood.setPraiseNum(0);
        ayMood.setContent("这是我的第一条微信朋友圈！");
        ayMood.setPublishTime(new Date());
        AyMood ayMood1 = ayMoodService.save(ayMood);
    }

    @Resource
    private AyMoodProducer ayMoodProducer;

    @Test
    public void testActiveMQ(){
        Destination  destination = new ActiveMQQueue("ay.queue");
        ayMoodProducer.sendMessage(destination,"hello activeMQ!");
    }

    @Test
    public void testActiveMQSynSave(){
        AyMood ayMood = new AyMood();
        ayMood.setId("2");
        ayMood.setUserId("1");
        ayMood.setPraiseNum(0);
        ayMood.setContent("这是我的第二条微信朋友圈！");
        ayMood.setPublishTime(new Date());
        String msg = ayMoodService.asynSave(ayMood);
        logger.info("【异步】发表说说保存"+msg);
    }

    // 测试同步执行方法findAll()
    @Test
    void testSync(){
        long start = System.currentTimeMillis();
        logger.info("第一次查询所有用户");
        List<AyUser> ayUsers = ayUserService.findAll();
        logger.info("第二次查询所有用户");
        List<AyUser> ayUsers2 = ayUserService.findAll();
        logger.info("第三次查询所有用户");
        List<AyUser> ayUsers3 = ayUserService.findAll();
        long end = System.currentTimeMillis();
        logger.info("3次查询总耗时:"+(end-start)+"毫秒");
    }

    // 异步查询所有用户
    @Test
    void findAsynAll() throws InterruptedException {
        long start = System.currentTimeMillis();
        logger.info("【异步】第一次查询所有用户");
        Future<List<AyUser>> ayUsers = ayUserService.findAsynAll();
        logger.info("【异步】第二次查询所有用户");
        Future<List<AyUser>> ayUsers2 = ayUserService.findAsynAll();
        logger.info("【异步】第三次查询所有用户");
        Future<List<AyUser>> ayUsers3 = ayUserService.findAsynAll();
        while(true){
            if(ayUsers.isDone() && ayUsers2.isDone() && ayUsers3.isDone()){
                break;
            }else{
                Thread.sleep(10);
            }
        }
        long end = System.currentTimeMillis();
        logger.info("【异步】3次查询总耗时:"+(end-start)+"毫秒");
    }

    @Resource
    private AyUserAttachmentRelService ayUserAttachmentRelService;

    @Test
    public void  testMongoDB(){
        AyUserAttachmentRel ayUserAttachmentRel = new AyUserAttachmentRel();
        ayUserAttachmentRel.setId("1");
        ayUserAttachmentRel.setUserId("1");
        ayUserAttachmentRel.setFileName("个人简历.doc");
        ayUserAttachmentRelService.save(ayUserAttachmentRel);
        logger.info("文档保存至MongoDB成功！");
    }*/
}
