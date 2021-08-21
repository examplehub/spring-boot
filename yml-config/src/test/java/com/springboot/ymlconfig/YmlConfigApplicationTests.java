package com.springboot.ymlconfig;

import com.pojo.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class YmlConfigApplicationTests {

  @Autowired User user;

  @Test
  void contextLoads() {
    Assertions.assertEquals("User{username='admin', password='112233', age=25}", user.toString());
  }
}
