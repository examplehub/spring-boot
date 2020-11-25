package com.examplehub.runner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunnerApplication implements ApplicationRunner, CommandLineRunner {

  public static void main(String[] args) {
    SpringApplication.run(RunnerApplication.class, args);
  }

  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("Hello World from Application Runner");
  }

  @Override
  public void run(String... args) throws Exception {
    System.out.println("Hello World from CommandLine Runner");
  }
}
