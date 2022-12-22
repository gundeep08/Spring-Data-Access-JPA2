package com.book.publish;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;
import com.book.publish.entities.Book;
import com.book.publish.entities.Category;
import com.google.common.collect.Lists;

@Service("springJpaTwoBookService")
@Transactional
public class BookServiceImpl implements BookService {
   
	@Autowired
    private BookRepository bookRepository;
    
    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly=true)
    public List<Book> findAll() {
        return Lists.newArrayList(bookRepository.findAll());
    }

    @Transactional(readOnly=true)
	public Optional<Book> findById(Long id) {
    	return bookRepository.findById(id);
	}

    @Transactional(readOnly=false)
	public Book save(Book book) {
    	return bookRepository.save(book);
	}
    
    @Transactional(readOnly=false)
   	public void deleteBook(Book book) {
       	bookRepository.delete(book);
   	}

    @Transactional(readOnly=true)
	public List<Category> findCategory() {
		return Lists.newArrayList(categoryRepository.findAll());
	}

    @Transactional(readOnly=true)
	public long findIdOfNewlyAddedBook() {
		return bookRepository.findIdOfNewlyAddedBook();
	}

}
