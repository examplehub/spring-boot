package com.examplehub.customapplication;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomapplicationApplication {

  public static void main(String[] args) {
    // SpringApplication.run(CustomapplicationApplication.class, args);
    SpringApplication app = new SpringApplication(CustomapplicationApplication.class);
    app.setBannerMode(Banner.Mode.OFF); /* turn off banner */
    app.run(args);
  }
}
