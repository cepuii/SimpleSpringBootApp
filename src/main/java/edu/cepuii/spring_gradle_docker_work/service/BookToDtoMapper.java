package edu.cepuii.spring_gradle_docker_work.service;

import edu.cepuii.spring_gradle_docker_work.dto.BookRequest;
import edu.cepuii.spring_gradle_docker_work.model.Book;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BookToDtoMapper {
  
  Book bookRequestToBook(BookRequest bookRequest);
}
