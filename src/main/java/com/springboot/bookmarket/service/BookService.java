package com.springboot.bookmarket.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.springboot.bookmarket.domain.Book;

public interface BookService {

	List<Book> getAllBookList();
	List<Book> getBookListByCategory(String category);
	Set<Book> getBookListByFilter(Map<String, List<String>> filter);
	Book getBookById(String bookId);
	void setNewBook(Book book);

	
}
