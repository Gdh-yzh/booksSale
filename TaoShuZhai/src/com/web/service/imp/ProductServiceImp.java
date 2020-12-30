package com.web.service.imp;


import java.util.List;

import com.web.dao.DAOFactory;
import com.web.model.Book;
import com.web.model.Product;
import com.web.service.ProductService;

public class ProductServiceImp implements ProductService{

	@Override
	public Book findById(int id) throws Exception {
		return DAOFactory.getProductDAO().findById(id);
	}

	@Override
	public List<Product> findByHot(int num) throws Exception {
		return DAOFactory.getProductDAO().findByHot(num);
	}

	@Override
	public List<Product> findByNew(int num) throws Exception {
		return DAOFactory.getProductDAO().findByNew(num);
	}

}
