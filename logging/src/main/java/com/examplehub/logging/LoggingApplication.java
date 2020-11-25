package com.examplehub.logging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LoggingApplication {
  private static final Logger logger = LoggerFactory.getLogger(LoggingApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(LoggingApplication.class, args);
    logger.info("info log");
    logger.warn("warn log");
    logger.error("error log");
    logger.debug("debug log");
  }
}
