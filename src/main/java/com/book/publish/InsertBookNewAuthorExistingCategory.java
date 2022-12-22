package com.book.publish;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.book.publish.entities.Author;
import com.book.publish.entities.Book;
import com.book.publish.entities.Category;

public class InsertBookNewAuthorExistingCategory {
	private static Logger logger = LoggerFactory.getLogger(
		InsertBookNewAuthorExistingCategory.class);
	
    public static void main(String... args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        BookService bookService = ctx.getBean(
            "springJpaTwoBookService", BookService.class);
        logger.info("============== Insert Book with new Author to existing category start ==============");
		Book book = new Book();
		book.setIsbn("5555");
		book.setPrice(50);
		book.setTitle("JPA Guide to Glory");
		
		List<Category> categoryList= bookService.findCategory();
		book.setCategory(categoryList.get(0));
	
		Set<Author> authorSet= new HashSet<>();
		Author author = new Author();
		author.setDescription("ORM Specialist");
		author.setFirst_name("Vitalik");
		author.setLast_name("Yurik");
		authorSet.add(author);
		book.setAuthor(authorSet);
		
		Book newlyAddedBook= bookService.save(book);
		logger.info("============== Find new book including its author and its category details start ==============");    
		 logger.info(newlyAddedBook.toString());
			
			if (newlyAddedBook.getAuthor() != null) {
				newlyAddedBook.getAuthor().forEach(a -> logger.info("\t" + a.toString()));
			}
			if (newlyAddedBook.getCategory() != null) {
				logger.info("\t" + newlyAddedBook.getCategory().toString());
			}
		logger.info("============== Find new book including its author and its category details end ==============");    
        ctx.close();
    }
}
