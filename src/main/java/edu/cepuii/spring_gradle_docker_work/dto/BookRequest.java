package edu.cepuii.spring_gradle_docker_work.dto;

import lombok.Data;

@Data
public class BookRequest {
  
  private String author;
  private String title;
  private String price;
}
