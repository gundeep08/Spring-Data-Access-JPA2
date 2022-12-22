package com.book.publish;

import java.util.List;
import java.util.Optional;
import com.book.publish.entities.Category;
import com.book.publish.entities.Book;

public interface BookService {
    List<Book> findAll();
    List<Category> findCategory();
    Optional<Book> findById(Long id);
    Book save(Book book);
    void deleteBook(Book book);
    long findIdOfNewlyAddedBook();
}
