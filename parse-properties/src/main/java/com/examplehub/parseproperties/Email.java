package com.examplehub.parseproperties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class Email {

  @Value("${spring.mail.host}")
  private String host;

  @Value("${spring.mail.username}")
  private String username;

  @Value("${spring.mail.password}")
  private String password;

  public Email() {}

  @Override
  public String toString() {
    return "Email{"
        + "host='"
        + host
        + '\''
        + ", username='"
        + username
        + '\''
        + ", password='"
        + password
        + '\''
        + '}';
  }
}
