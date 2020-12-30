package com.web.dao;


import java.util.List;

import com.web.model.Book;
import com.web.model.Product;

public interface ProductDAO {
	
	public Book findById(int id) throws Exception;

	public List<Product> findByHot(int num) throws Exception;
	
	public List<Product>  findByNew(int num) throws Exception;
}
