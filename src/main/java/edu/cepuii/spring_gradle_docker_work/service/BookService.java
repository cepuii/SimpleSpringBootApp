package edu.cepuii.spring_gradle_docker_work.service;

import edu.cepuii.spring_gradle_docker_work.model.Book;
import java.util.List;

public interface BookService {
  
  Book getBookById(Long id);
  
  List<Book> getAllBooks();
  
  void addBook(Book book);
}
