package com.example.devtools;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

  @RequestMapping("/")
  public String home() {
    return "spring boot dev-tools";
  }
}
