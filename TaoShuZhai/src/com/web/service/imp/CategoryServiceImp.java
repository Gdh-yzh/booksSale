package com.web.service.imp;

import java.util.List;

import com.web.dao.DAOFactory;
import com.web.model.Category;
import com.web.service.CategoryService;

public class CategoryServiceImp implements CategoryService{

	@Override
	public List<Category> findAll() throws Exception {
		return DAOFactory.getCategoryDAO().findAll();
	}

//	@Override
//	public List<Category> findByParentId(int pid) throws Exception {
//		return DAOFactory.getCategoryDAO().findByParentId(pid);
//	}

}
