package edu.cepuii.spring_gradle_docker_work.service;

import edu.cepuii.spring_gradle_docker_work.dao.BookEntity;
import edu.cepuii.spring_gradle_docker_work.dao.BookRepository;
import edu.cepuii.spring_gradle_docker_work.model.Book;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DefaultBookService implements BookService {
  
  private BookRepository bookRepository;
  private BookToEntityMapper mapper;
  
  @Override
  public Book getBookById(Long id) {
    BookEntity bookEntity = bookRepository
        .findById(id)
        .orElseThrow(() -> new IllegalArgumentException("Book not found by id:" + id));
    
    return mapper.bookEntityToBook(bookEntity);
  }
  
  @Override
  public List<Book> getAllBooks() {
    Iterable<BookEntity> iterable = bookRepository.findAll();
    ArrayList<Book> books = new ArrayList<>();
    for (BookEntity bookEntity : iterable) {
      books.add(mapper.bookEntityToBook(bookEntity));
    }
    return books;
  }
  
  @Override
  public void addBook(Book book) {
    BookEntity bookEntity = mapper.bookToBookEntity(book);
    bookRepository.save(bookEntity);
  }
}
