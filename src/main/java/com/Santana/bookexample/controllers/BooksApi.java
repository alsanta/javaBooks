package com.Santana.bookexample.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Santana.bookexample.models.Book;
import com.Santana.bookexample.services.BookService;

@RestController
public class BooksApi {
	
    private final BookService bookService;
    
    public BooksApi(BookService bookService){
        this.bookService = bookService;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Book update(@PathVariable("id") Long id, @RequestParam(value="title") String title, 	@RequestParam(value="description") String desc, @RequestParam(value="language") String lang, 	@RequestParam(value="pages") Integer numOfPages) {
    	Book b = this.bookService.findBook(id);
    	b.setTitle(title);
    	b.setDescription(desc);
    	b.setLanguage(lang);
    	b.setNumberOfPages(numOfPages);
        return this.bookService.updateBook(b);
    }
    
//    Get all Books
    @GetMapping("/api/books/all")
    public List<Book> allBooks(){
    	return this.bookService.allBooks();
    }
//    Delete book by Id (The number for the id is being pulled from the route)
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
        bookService.deleteBook(id);
    }
//    Create a new Book entry using form data (It is returning the entire database entry of the new book)
    @PostMapping("/api/books/create")
    public Book create(@RequestParam(value="title") String title, 	@RequestParam(value="description") String desc, @RequestParam(value="language") String lang,@RequestParam(value="pages") Integer numOfPages) {
    	Book book = new Book(title,desc,lang,numOfPages);
    	return this.bookService.createBook(book);
    }
}