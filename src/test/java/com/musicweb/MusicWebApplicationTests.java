package com.musicweb;

import com.musicweb.dao.CommitDao;
import com.musicweb.entity.CommitEntiy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

@SpringBootTest
class MusicWebApplicationTests {

    @Resource
    CommitDao commitDao;

    @Test
    void contextLoads() {
        CommitEntiy commitEntiy=new CommitEntiy();
        java.util.Date date = new java.util.Date();//获取一个Date对象
        Timestamp timeStamp = new Timestamp(date.getTime());//将日期时间转换为数据库中的timestamp类型
        commitEntiy.setCreatTime(timeStamp.toString());
        commitEntiy.setMusiceid(32);
        commitEntiy.setUserid(32);
        commitEntiy.setImg("http://oss.wzszz.top/128_128.jpg?imageView2/1/w/64/h/64/interlace/1/q/75");
        commitEntiy.setContent("周子雷的再见警察");
        commitDao.addCommit(commitEntiy);
    }

    @Test
    void ssadfa(){
        List<CommitEntiy> commitEntiys=commitDao.selectAllCommit(32);
        for (CommitEntiy commitEntiy : commitEntiys) {
            System.out.println(commitEntiy.getCreatTime());
            System.out.println(commitEntiy.getImg());
            System.out.println(commitEntiy.getContent());
        }
    }

}
