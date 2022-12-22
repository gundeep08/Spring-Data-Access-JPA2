package com.book.publish;

import org.springframework.context.support.GenericXmlApplicationContext;
import com.book.publish.entities.Book;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeleteRecentlySavedBookWithAuthor {
	private static Logger logger = LoggerFactory.getLogger(
		DeleteRecentlySavedBookWithAuthor.class);
	
    public static void main(String... args) {
    	GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        BookService bookService = ctx.getBean("springJpaTwoBookService", BookService.class);
        Long id= bookService.findIdOfNewlyAddedBook();
        Optional<Book>bookResponse= bookService.findById(id);
		logger.info("============== Delete Recently saved Book along with the Author start ==============");
		bookService.deleteBook(bookResponse.get());
		listBooks(bookService.findAll());
		logger.info("============== Delete Recently saved Book along with the Author end ==============");    
        ctx.close();
    }
    
    public static void listBooks(List<Book> books) {
		logger.info(" ---- Listing books excludes the newly added book along with its autor as its been deleted:");
		books.forEach(b -> {
			logger.info(b.toString());
			if (b.getAuthor() != null) {
				b.getAuthor().forEach(a -> logger.info("\t" + a.toString()));
			}
			if (b.getCategory() != null) {
				logger.info("\t" + b.getCategory().toString());
			}
		});
    }
    
}