package edu.cepuii.spring_gradle_docker_work.service;

import edu.cepuii.spring_gradle_docker_work.dao.BookEntity;
import edu.cepuii.spring_gradle_docker_work.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToEntityMapper {
  
  BookEntity bookToBookEntity(Book book);
  
  Book bookEntityToBook(BookEntity bookEntity);
  
}
