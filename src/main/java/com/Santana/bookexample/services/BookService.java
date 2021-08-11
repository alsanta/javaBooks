package com.Santana.bookexample.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Santana.bookexample.models.Book;
import com.Santana.bookexample.repositories.BookRepository;

//	Here we will make all the methods (functions) that will call the Queries from the repository
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
    
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    // returns all the books
    public List<Book> allBooks() {
        return (List<Book>)bookRepository.findAll();
    }
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    // retrieves a book
    public Book findBook(Long id) {
    	return this.bookRepository.findById(id).orElse(null);
    }
//    Deletes by ID
    public void deleteBook(Long id) {
    	this.bookRepository.deleteById(id);
    }
//    Update book
    public Book updateBook(Book b) {
    	return bookRepository.save(b);
    }
    
}
