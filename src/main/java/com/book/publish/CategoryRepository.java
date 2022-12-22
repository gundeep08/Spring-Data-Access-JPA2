package com.book.publish;

import org.springframework.data.repository.CrudRepository;

import com.book.publish.entities.Book;
import com.book.publish.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long> {
 
}
