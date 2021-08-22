package com.springboot.jdbc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
class JdbcApplicationTests {

  @Autowired DataSource dataSource;

  @Test
  void contextLoads() {

//    System.out.println(dataSource.getClass());
//    try {
//      Connection connection = dataSource.getConnection();
//      System.out.println(connection);
//    } catch (SQLException throwables) {
//      throwables.printStackTrace();
//    }
  }

}
