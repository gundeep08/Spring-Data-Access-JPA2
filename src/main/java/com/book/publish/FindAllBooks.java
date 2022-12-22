package com.book.publish;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.context.support.GenericXmlApplicationContext;

import com.book.publish.entities.Author;
import com.book.publish.entities.Book;
import com.book.publish.entities.Category;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FindAllBooks {
	private static Logger logger = LoggerFactory.getLogger(FindAllBooks.class);
	
    public static void main(String... args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:spring/app-context-annotation.xml");
        ctx.refresh();
        BookService bookService = ctx.getBean("springJpaTwoBookService", BookService.class);
        listBooks(bookService.findAll());
        ctx.close();
    }

    private static void listBooks(List<Book> books) {
        logger.info("List all Books Details: ");
        for (Book book: books) {
            logger.info(book.toString());
        }
    }
}
