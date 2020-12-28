package com.wyu.service;

import java.text.ParseException;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.wyu.pojo.Book;
import com.wyu.pojo.BookAll;
import com.wyu.pojo.BookQuery;
@Service
public interface BookService {

	List<BookAll> findBooks() ;

	int insertBook(BookAll book);
	long countBook();

	int updateBookByNumber(BookAll book);

	int deleteBookByNumber(String number);

	int deleteBookByNumbers(List<String> number);

	List<BookAll> findBooksByText(String text);

	List<BookAll> findBooksBySort(String text, String sortName, String sortOrder);

	List<BookAll> queryBooks(BookQuery book) throws ParseException;

	List<BookAll> queryBooksBySort(BookQuery book, String sortOrder, String sortName) throws ParseException;

	List<BookAll> findBookByNumber(String booknumber);

	Book findBookByKey(String booknumber);

	int updateBookByNumber(Book book);

	int updateBookBySelect(Book book);

	int findBookExist(String booknumber);

	List<Book> addBooks(MultipartFile file) throws Exception;

	int addManyBooks(List<Book> list);



}
