package edu.cepuii.spring_gradle_docker_work.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
  
  @GetMapping("/hello")
  public String hello(@RequestParam(required = false) String name) {
    return "Hello" + name;
  }
}