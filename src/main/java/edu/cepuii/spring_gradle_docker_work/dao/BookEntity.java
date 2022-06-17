package edu.cepuii.spring_gradle_docker_work.dao;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class BookEntity {
  
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long id;
  
  String author;
  
  String title;
  
  Double price;
}
