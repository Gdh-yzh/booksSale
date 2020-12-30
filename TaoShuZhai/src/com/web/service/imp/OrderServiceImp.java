package com.web.service.imp;

import com.web.dao.DAOFactory;
import com.web.model.Order;
import com.web.service.OrderService;

public class OrderServiceImp implements OrderService{

	@Override
	public int  save(Order order) throws Exception {
		 return DAOFactory.getOrderDAO().save(order);
	}

}
