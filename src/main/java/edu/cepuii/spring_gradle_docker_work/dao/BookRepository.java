package edu.cepuii.spring_gradle_docker_work.dao;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<BookEntity, Long> {

}
