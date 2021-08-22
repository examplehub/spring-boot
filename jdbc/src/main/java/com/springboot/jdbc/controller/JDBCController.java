package com.springboot.jdbc.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JDBCController {
  @Autowired JdbcTemplate jdbcTemplate;

  @RequestMapping("/users")
  public List<Map<String, Object>> users() {
    String sql = "SELECT * FROM mybatis.user";
    return jdbcTemplate.queryForList(sql);
  }

  @RequestMapping("/query/{id}")
  public List<Map<String, Object>> queryByID(@PathVariable("id") int id) {
    String sql = "SELECT * FROM mybatis.user WHERE id = " + id;
    return jdbcTemplate.queryForList(sql);
  }

  @RequestMapping("/update/{id}")
  public String update(@PathVariable("id") int id) {
    String sql = "update mybatis.user SET name = ?, password = ? where id = " + id;
    jdbcTemplate.update(sql, "new_user", "abc123");
    return "update ok";
  }

  @RequestMapping("/add/{id}/{name}/{password}")
  public String add(
      @PathVariable("id") int id,
      @PathVariable("name") String name,
      @PathVariable("password") String password) {
    String sql = "insert into mybatis.user(id, name, password) value(?, ?, ?)";
    jdbcTemplate.update(sql, id, name, password);
    return "insert ok";
  }

  @RequestMapping("/delete/{id}")
  public String delete(@PathVariable("id") int id) {
    String sql = "delete from mybatis.user where id = " + id;
    jdbcTemplate.update(sql);
    return "delete ok";
  }
}
