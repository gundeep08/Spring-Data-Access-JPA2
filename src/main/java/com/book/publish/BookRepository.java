package com.book.publish;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.book.publish.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
 
	@Query(nativeQuery = true, value = "select max(b.id) from Book b")
    long findIdOfNewlyAddedBook();
}
