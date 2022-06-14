package edu.cepuii.spring_gradle_docker_work.model;

import lombok.Value;

@Value
public class Book {
  
  Long id;
  String author;
  String title;
  Double price;
}
