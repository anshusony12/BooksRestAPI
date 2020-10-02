package com.rest.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rest.book.dao.BookRepository;
import com.rest.book.entities.Book;

@Component
public class BookService {
//	private static List<Book> list = new ArrayList<>();
	
//	static {
//		list.add(new Book(12, "Python", "abc"));
//		list.add(new Book(13, "java", "xyz"));
//		list.add(new Book(14, "C", "abbc"));
//	}
	@Autowired
	private BookRepository bookRepository;
	
//	get all books
	public List<Book> getAllBooks(){
		List<Book> list = (List<Book>) this.bookRepository.findAll();
		return list;
	}
	
	public Book getBookById(int id) {
		Book book = null;
		try {
			book = this.bookRepository.findBookById(id);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return book;
	}
	
	public Book addBook(Book book) {
		Book save = this.bookRepository.save(book);
		return save;
	}
	
	public void deleteBook(int bookId) {
		try {
//		list = list.stream().filter(book ->book.getId()!=bookId).collect(Collectors.toList());
			this.bookRepository.deleteById(bookId);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateBook(Book book) {
//		list = list.stream().map(b -> {
//			if(b.getId() == bookId) {
//				b.setTitle(book.getTitle());
//				b.setAuthor(book.getAuthor());
//			}
//			return b;
//		}).collect(Collectors.toList());
		this.bookRepository.save(book);
	}
}
