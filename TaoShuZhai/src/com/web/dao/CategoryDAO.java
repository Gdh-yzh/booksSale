package com.web.dao;

import java.util.List;

import com.web.model.Category;

public interface CategoryDAO {

	public List<Category> findAll() throws Exception;
	
//	public List<Category> findByParentId(int pid) throws Exception;

	
}
