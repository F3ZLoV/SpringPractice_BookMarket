package com.springboot.bookmarket.service;
import java.util.*;
import com.springboot.bookmarket.domain.Book;
public interface BookService {
    List<Book> getAllBookList();
    Book getBookById(String bookId);
    List<Book> getBookListByCategory(String category);
    Set<Book> getBookListByFilter(Map<String, List<String>> filter);
}
