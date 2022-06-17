package edu.cepuii.spring_gradle_docker_work.controller;

import edu.cepuii.spring_gradle_docker_work.dto.BookRequest;
import edu.cepuii.spring_gradle_docker_work.model.Book;
import edu.cepuii.spring_gradle_docker_work.service.BookService;
import edu.cepuii.spring_gradle_docker_work.service.BookToDtoMapper;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
@RequiredArgsConstructor
public class BookController {
  
  private final BookService service;
  private final BookToDtoMapper dtoMapper;
  
  @GetMapping("/{id}")
  public Book getBookById(@PathVariable long id) {
    return service.getBookById(id);
  }
  
  @GetMapping
  public List<Book> getAllBooks(@RequestParam(required = false) String author) {
    if (author != null) {
      return service.getByAuthor(author);
    }
    return service.getAllBooks();
  }
  
  @PostMapping
  public void addBook(@RequestBody BookRequest bookRequest) {
    service.addBook(dtoMapper.bookRequestToBook(bookRequest));
  }
  
}
