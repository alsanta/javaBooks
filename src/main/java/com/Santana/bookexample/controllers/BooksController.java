package com.Santana.bookexample.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Santana.bookexample.models.Book;
import com.Santana.bookexample.services.BookService;

@Controller
public class BooksController {
    private final BookService bookService;
    
    public BooksController(BookService bookService) {
        this.bookService = bookService;
    }
    
    @RequestMapping("/books")
    public String index(Model model) {
        List<Book> books = bookService.allBooks();
        model.addAttribute("books", books);
        return "index.jsp";
    }
    
    @GetMapping("/books/new")
    public String newBook(@ModelAttribute("book") Book book) {
    	return "new.jsp";
    }
    
    @PostMapping("/book/create")
    public String create(@Valid @ModelAttribute("book") Book book, BindingResult result) {
    	if(result.hasErrors()) {
    		return "new.jsp";
    	}
    	this.bookService.createBook(book);
    	return "redirect:/books";
	}
    
    @GetMapping("/book/view/{id}")
    public String view(@PathVariable("id") Long id, Model model) {
    	Book b = this.bookService.findBook(id);
    	model.addAttribute("book", b);
    	return "show.jsp";
    }
    
    @GetMapping("book/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
    	this.bookService.deleteBook(id);
    	return "redirect:/books";
    }
    
    @GetMapping("book/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
    	Book book = this.bookService.findBook(id);
    	model.addAttribute("book", book);
    	return "edit.jsp";
    }
    
    @PostMapping("book/update/{id}")
    public String update(@PathVariable("id") Long id,@Valid  @ModelAttribute ("book") Book book,BindingResult result) {
    	if(result.hasErrors()) {
    		return "edit.jsp";
    	}
    	this.bookService.updateBook(book);
    	return"redirect:/books";
    }
}