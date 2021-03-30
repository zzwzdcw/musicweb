package com.musicweb;

import com.musicweb.dao.LoginDao;
import com.musicweb.entity.UserEntiy;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MusicWebApplicationTests {

    private LoginDao loginDao;
    @Test
    void contextLoads() {

    }
    @Test
    public void test1(){

//        UserEntiy userEntiy=loginDao.login("1");
//        System.out.println(userEntiy.toString());
    }

}
