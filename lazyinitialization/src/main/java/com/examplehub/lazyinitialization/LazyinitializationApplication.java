package com.examplehub.lazyinitialization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LazyinitializationApplication {

  @Bean("user1")
  public User getUser1() {
    return new User("Jack", 23);
  }

  @Bean("user2")
  public User getUser2() {
    return new User("Jack", 23);
  }

  public static void main(String[] args) {
    ApplicationContext context = SpringApplication.run(LazyinitializationApplication.class, args);
    System.out.println("Application context initialized.");

    User jack = context.getBean("user1", User.class);
    System.out.println(jack.toString());
    User tom = context.getBean("user2", User.class);
    System.out.println(tom.toString());
  }
}
