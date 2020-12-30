package com.web.service;

import java.util.List;

import com.web.model.Category;

public interface CategoryService {
	
	public List<Category> findAll() throws Exception;
	
//	public List<Category> findByParentId(int pid) throws Exception;

}
