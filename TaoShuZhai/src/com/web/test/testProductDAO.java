package com.web.test;

import org.junit.Test;

import com.web.dao.DAOFactory;
import com.web.model.Book;

public class testProductDAO {

	@Test
	public void test() throws Exception {
		Book book = DAOFactory.getProductDAO().findById(2);
		System.out.println(book.getAuthor() + "----------\n" + book.getProductName() + "\n" + book.getDescription());
	}

}
