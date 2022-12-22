package com.book.publish;

import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.GenericXmlApplicationContext;
import com.book.publish.entities.Book;

public class FindBookDetailsByBookId {
	private static Logger logger = LoggerFactory.getLogger(FindBookDetailsByBookId.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        BookService bookService = ctx.getBean("springJpaTwoBookService", BookService.class);
        Long id = 1L;
        logger.info("============== Find Book along with the Author and Category details based on bookId start ==============");
        Optional<Book>bookResponse= bookService.findById(id);
        Book book = bookResponse.get();
        logger.info(book.toString());
		
		if (book.getAuthor() != null) {
			book.getAuthor().forEach(a -> logger.info("\t" + a.toString()));
		}
		if (book.getCategory() != null) {
			logger.info("\t" + book.getCategory().toString());
		}
        logger.info("============== Find Book along with the Author and Category details based on bookId end ==============");
        ctx.close();
        
    }
}
