package com.rest.book.dao;

import org.springframework.data.repository.CrudRepository;

import com.rest.book.entities.Book;

public interface BookRepository extends CrudRepository<Book, Integer> {
	public Book findBookById(int bookId);
}
